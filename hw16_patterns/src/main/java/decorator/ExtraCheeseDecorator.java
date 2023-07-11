package decorator;

public class ExtraCheeseDecorator extends OrderDecorator {
    public ExtraCheeseDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + 2.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Extra Cheese";
    }
}