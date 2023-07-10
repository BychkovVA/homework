package adapter;

public class CreditCardPayment  {
    private double amount;

    public CreditCardPayment(double amount) {
        this.amount = amount;
    }

    public void swipeCard() {
        System.out.println("Swiping credit card for payment of $" + amount);
    }
}