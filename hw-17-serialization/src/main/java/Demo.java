import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        JsonProcessor processor = new JsonProcessor();

        try {
            String inputJson = "E:\\GIT\\homework\\hw-17-serialization\\src\\main\\resources\\input.json";
            String outputJson = "E:\\GIT\\homework\\hw-17-serialization\\src\\main\\resources\\output.json";
            processor.processJsonFile( inputJson, outputJson);
            System.out.println("Response file successfully generated!");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
