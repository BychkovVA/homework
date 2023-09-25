package observer;

import model.DataEvent;
import model.EventType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataObserver implements Runnable {
    private static final String INSERTED_FILE = "./src/main/resources/inserted.txt";
    private static final String DELETED_FILE = "./src/main/resources/deleted.txt";
    private final ObservedList observedList;

    public DataObserver(ObservedList observedList) {
        this.observedList = observedList;
    }

    @Override
    public void run() {
        while (true) {
            try {


                DataEvent event = observedList.getEventQueue().take();

                if(event.getType() == EventType.INSERTED) {
                    //Запись в файл inserted.txt
                    try(BufferedWriter writer = new BufferedWriter(new FileWriter(INSERTED_FILE, true))){
                        writer.write(event.getValue() + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if(event.getType() == EventType.DELETED) {
                    //Запись в файл deleted.txt
                    try(BufferedWriter writer = new BufferedWriter(new FileWriter(DELETED_FILE, true))){
                        writer.write(event.getValue() + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}