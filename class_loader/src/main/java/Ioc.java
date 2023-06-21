
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

class Ioc {

    private Ioc() {
    }

    static TestLoggingInterface createTestClass() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLogging());
        return (TestLoggingInterface) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLoggingInterface myClass;
        private final Method[] logMethodList;

        DemoInvocationHandler(TestLoggingInterface myClass) {
            this.myClass = myClass;
            this.logMethodList = Arrays.stream(TestLoggingInterface.class.getMethods())
                    .filter(method -> method.isAnnotationPresent(Log.class))
                    .toArray(Method[]::new);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ( Arrays.stream(logMethodList).anyMatch(method::equals)) {
                String paramlist = "";
                for (Object arg : args) {
                    if (arg.getClass() == Object[].class) {
                        for (Object intArg : (Object[]) arg) {
                            paramlist = paramlist + " " + intArg;
                        }
                    } else {
                        paramlist = paramlist + " " + arg;
                    }
                }
                System.out.println("executed method:" + method.getName() + " param:"+ paramlist);
            }
            return method.invoke(myClass, args);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" +
                    "myClass=" + myClass +
                    '}';
        }
    }
}