
public class Demo {

    public static void main(String[] args) {

        try {


            TestLoggingInterface myClass = Ioc.createTestClass();


            myClass.calculation(1);
            myClass.calculation(1,1);
            myClass.calculation(1,"Demo");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
