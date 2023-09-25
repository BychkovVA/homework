package observer;

import model.DataEvent;
import model.EventType;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class ObservedList {
    private final CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
    private final BlockingQueue<DataEvent> eventQueue = new LinkedBlockingQueue<>();

    public void insert(Integer value) {
        list.add(value);
        eventQueue.add(new DataEvent(EventType.INSERTED, value));
    }

    public void delete(Integer value) {
        list.remove(value);
        eventQueue.add(new DataEvent(EventType.DELETED, value));
    }

    public BlockingQueue<DataEvent> getEventQueue() {
        return eventQueue;
    }
}

