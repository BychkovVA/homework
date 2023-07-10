package adapter;

public class Demo {
    public static void main(String[] args) {
        PaymentSystem existingPaymentSystem = new ExistingPaymentSystem();
        existingPaymentSystem.processPayment(100.0);

        PaymentSystem creditCardPayment = new CreditCardAdapter(new CreditCardPayment(200.0));
        creditCardPayment.processPayment(200.0);

        PaymentSystem paypalPayment = new PaypalAdapter(new PaypalPayment(300.0));
        paypalPayment.processPayment(300.0);
    }
}
