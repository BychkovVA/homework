package decorator;

public class BasicOrder  implements Order {
    @Override
    public double calculateCost() {
        return 10.0;
    }

    @Override
    public String getDescription() {
        return "Basic Order";
    }
}