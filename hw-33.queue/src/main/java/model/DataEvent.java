package model;

public class DataEvent {
    private final EventType type;
    private final int value;

    public DataEvent(EventType type, int value) {
        this.type = type;
        this.value = value;
    }

    public EventType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}