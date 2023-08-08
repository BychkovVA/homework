import model.ChatData;
import model.ChatMessage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
        File file = new File("E:\\GIT\\homework\\hw-17-sms\\src\\main\\resources\\sms.json");
        String jsonContent = Files.readString(file.toPath());

        ChatData chatData = objectMapper.readValue(jsonContent, ChatData.class);

        List<ChatMessage> uniqueMessages = chatData.getChatSessions().stream()
                    .flatMap(chatSession -> chatSession.getMessages().stream())
                    .distinct()
                    .sorted(Comparator.comparing(ChatMessage::getDate))
                    .collect(Collectors.toList());


            String outputJson = objectMapper.writeValueAsString(uniqueMessages);
            Files.writeString(new File("output.json").toPath(), outputJson);

            String deserializedJson = Files.readString(new File("output.json").toPath());
            List<ChatMessage> deserializedMessages = objectMapper.readValue(deserializedJson, objectMapper.getTypeFactory().constructCollectionType(List.class, ChatMessage.class));
            deserializedMessages.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
