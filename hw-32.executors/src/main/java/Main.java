import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Void> thread1Future = CompletableFuture.runAsync(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Поток 1: " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(1000); // Для наглядности (можно убрать)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 9; i >= 0; i--) {
                System.out.println("Поток 1: " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, executorService);

        CompletableFuture<Void> thread2Future = CompletableFuture.runAsync(() -> {
            try {
                thread1Future.get(); // Ждем завершения потока 1
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Поток 2: " + i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 9; i >= 0; i--)  {
                    System.out.println("Поток 2: " + i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, executorService);

        // Дожидаемся завершения обоих потоков
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(thread1Future, thread2Future);
        try {
            combinedFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}