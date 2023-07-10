package decorator;

public class RestaurantOrder {
    public static void main(String[] args) {

        Order order = new BasicOrder();


        order = new ExtraCheeseDecorator(order);
        order = new LargePortionDecorator(order);


        System.out.println("Order Description: " + order.getDescription());
        System.out.println("Order Cost: " + order.calculateCost());
    }
}