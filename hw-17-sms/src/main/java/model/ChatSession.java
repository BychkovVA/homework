package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChatSession {
    @JsonProperty("chat_id")
    private int chat_id;

    @JsonProperty("chat_identifier")
    private String chat_identifier;

    @JsonProperty("display_name")
    private String display_name;

    @JsonProperty("is_deleted")
    private int is_deleted;

    private List<Member> members;
    private List<ChatMessage> messages;

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public int getChatId() {
        return chat_id;
    }

    public String getChatIdentifier() {
        return chat_identifier;
    }

    public String getDisplayName() {
        return display_name;
    }

    public int getIsDeleted() {
        return is_deleted;
    }

    public List<Member> getMembers() {
        return members;
    }

    public ChatSession(int chat_id, String chat_identifier, String display_name, int is_deleted, List<Member> members, List<ChatMessage> messages) {
        this.chat_id = chat_id;
        this.chat_identifier = chat_identifier;
        this.display_name = display_name;
        this.is_deleted = is_deleted;
        this.members = members;
        this.messages = messages;
    }

    public ChatSession() {
    }
}
