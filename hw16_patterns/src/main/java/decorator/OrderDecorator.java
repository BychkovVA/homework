package decorator;

abstract class OrderDecorator implements Order {
    protected Order decoratedOrder;

    public OrderDecorator(Order decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public double calculateCost() {
        return decoratedOrder.calculateCost();
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription();
    }
}