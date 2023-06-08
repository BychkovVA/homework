import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;



public class TestFramework {

    private static final List<String> successfulTests = new ArrayList<>();
    private static final List<String> failedTests = new ArrayList<>();

    public static void runTests(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            Object obj = clazz.newInstance();


            Method[] methods = clazz.getDeclaredMethods();
            List<Method> beforeMethods = new ArrayList<>();
            List<Method> afterMethods = new ArrayList<>();
            List<Method> testMethods = new ArrayList<>();

            for (Method method : methods) {
                if (method.isAnnotationPresent(Before.class)) {
                    beforeMethods.add(method);
                } else if (method.isAnnotationPresent(After.class)) {
                    afterMethods.add(method);
                } else if (method.isAnnotationPresent(Test.class)) {
                    testMethods.add(method);
                }
            }

            for (Method testMethod : testMethods) {
                try {
                    for (Method beforeMethod : beforeMethods) {
                        beforeMethod.invoke(obj);
                    }
                    testMethod.invoke(obj);
                    successfulTests.add(testMethod.getName());
                } catch (Exception e) {
                    failedTests.add(testMethod.getName());
                } finally {
                    for (Method afterMethod : afterMethods) {
                        afterMethod.invoke(obj);
                    }
                }
            }

            printResults(successfulTests.size(), failedTests.size(), successfulTests, failedTests);

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error while creating instance of class: " + e.getMessage());
        }
    }

    private static void printResults(int successfulCount, int failedCount, List<String> successfulTests, List<String> failedTests) {
        System.out.println("Successful tests: " + successfulCount);
        for (String testName : successfulTests) {
            System.out.println(" - " + testName);
        }
        System.out.println("Failed tests: " + failedCount);
        for (String testName : failedTests) {
            System.out.println(" - " + testName);
        }
    }

}
