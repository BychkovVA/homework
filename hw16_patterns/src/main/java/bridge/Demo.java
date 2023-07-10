package bridge;

public class Demo {
        public static void main(String[] args) {
            Shape redCircle = new Circle(new RedColor());
            Shape blueRectangle = new Rectangle(new BlueColor());
            Shape redTriangle = new Triangle(new RedColor());

            redCircle.draw();
            blueRectangle.draw();
            redTriangle.draw();
        }
}
