package adapter;

public class CreditCardAdapter  implements PaymentSystem {
    private CreditCardPayment creditCardPayment;

    public CreditCardAdapter(CreditCardPayment creditCardPayment) {
        this.creditCardPayment = creditCardPayment;
    }

    public void processPayment(double amount) {
        creditCardPayment.swipeCard();
    }
}
