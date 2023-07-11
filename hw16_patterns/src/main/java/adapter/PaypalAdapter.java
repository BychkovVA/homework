package adapter;

public class PaypalAdapter implements PaymentSystem {
    private PaypalPayment paypalPayment;

    public PaypalAdapter(PaypalPayment paypalPayment) {
        this.paypalPayment = paypalPayment;
    }

    public void processPayment(double amount) {
        paypalPayment.login();
    }
}
