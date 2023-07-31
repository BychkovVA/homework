package model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChatData {

    @JsonProperty("chat_sessions")
    private List<ChatSession> chat_sessions;

    public List<ChatSession> getChatSessions() {
        return chat_sessions;
    }

    public void setChatSessions(List<ChatSession> chatSessions) {
        this.chat_sessions = chatSessions;
    }

    public ChatData(List<ChatSession> chat_sessions) {
        this.chat_sessions = chat_sessions;
    }

    public ChatData() {
    }
}