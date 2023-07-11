public class TestLogging implements TestLoggingInterface{
    
    public void calculation(int param) {
        System.out.println("run method: calculation, param: " + param);

    }

    public void calculation(int param1, int param2) {
        System.out.println("run method: calculation, params: [" + param1 + ", " + param2 + "]");
    }

    public void calculation(int param1, String param2) {
        System.out.println("run method: calculation, params: [" + param1 + ", " + param2 + "]");
    }

}
