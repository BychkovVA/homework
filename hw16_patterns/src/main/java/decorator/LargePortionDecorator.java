package decorator;

public class LargePortionDecorator extends OrderDecorator {
    public LargePortionDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + 5.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Large Portion";
    }
}