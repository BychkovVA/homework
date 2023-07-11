import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JsonProcessor {
    private final ObjectMapper objectMapper;

    public JsonProcessor() {
        this.objectMapper = new ObjectMapper();
    }

    public void processJsonFile(String inputFile, String outputFile) throws IOException {

        File jsonFile = new File(inputFile);
        Employee employee = objectMapper.readValue(jsonFile, Employee.class);

        String name = employee.getName();
        int age = employee.getAge();

        employee.setStatus("fired");

        File responseFile = new File(outputFile);
        objectMapper.writeValue(responseFile, employee);
    }
}
