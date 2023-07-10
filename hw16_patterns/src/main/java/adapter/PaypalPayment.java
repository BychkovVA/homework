package adapter;

public class PaypalPayment {
    private double amount;

    public PaypalPayment(double amount) {
        this.amount = amount;
    }

    public void login() {
        System.out.println("Logging into PayPal for payment of $" + amount);
    }
}

