import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier runBarrier = new CyclicBarrier(2);
        CyclicBarrier printBarrier = new CyclicBarrier(2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new PrinterThread(1, runBarrier, printBarrier));
        executorService.submit(new PrinterThread(2, runBarrier, printBarrier));

        executorService.shutdown();
    }
}