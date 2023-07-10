package adapter;

public class ExistingPaymentSystem implements PaymentSystem {
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " using the existing payment system.");
    }
}