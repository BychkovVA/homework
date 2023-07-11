
public interface TestLoggingInterface {


    void calculation(int param1);
    @Log
    void calculation(int param1, int param2);
    @Log
    void calculation(int param1, String param2);



}
