import java.util.concurrent.CyclicBarrier;

class PrinterThread implements Runnable {

    private final int id;
    private final CyclicBarrier runBarrier;
    private final CyclicBarrier printBarrier;

    PrinterThread(int id, CyclicBarrier runBarrier, CyclicBarrier printBarrier) {
        this.id = id;
        this.runBarrier = runBarrier;
        this.printBarrier = printBarrier;
    }

    @Override
    public void run() {
        try {
            runBarrier.await();

            while (!Thread.currentThread().isInterrupted()) {
                if (id == 1) {
                    printNumbers();
                }
                printBarrier.await();

                if (id == 2) {
                    printNumbers();
                }
                printBarrier.await();
                Thread.currentThread().interrupt();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void printNumbers() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Поток " + id + ":" + i);
        }
        for (int i = 9; i >= 1; i--) {
            System.out.println("Поток " + id + ":" + i);
        }
    }
}