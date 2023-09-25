import observer.DataObserver;
import observer.ObservedList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ObservedList observedList = new ObservedList();
        DataObserver observer = new DataObserver(observedList);

        Thread observerThread = new Thread(observer);
        observerThread.start();

        observedList.insert(1);
        observedList.insert(2);
        observedList.delete(1);
        observedList.delete(2);

        // Останавливаем наблюдателя через некоторое время
        Thread.sleep(1000);
        observerThread.interrupt();

        observerThread.join();
    }
}