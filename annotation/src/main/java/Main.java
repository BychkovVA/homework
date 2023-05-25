public class Main {
    public static void main(String[] args) {

        try {

            TestFramework.runTests("ExampleTest");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
