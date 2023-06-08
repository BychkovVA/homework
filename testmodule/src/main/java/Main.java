import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args) {
        try {

        CustomClass cs = new CustomClass();
        Class<?> clazz = cs.getClass();
        Method[] methods = clazz.getDeclaredMethods();


        System.out.println(cs.toString());

        }
        catch (Exception e) {
        e.printStackTrace();
        }
    }

}
