package bridge;

class Circle implements Shape {
    private final Color color;

    public Circle(Color color) {
        this.color = color;
    }

    public void draw() {
        System.out.print("Draw a circle ");
        color.fill();
    }
}
