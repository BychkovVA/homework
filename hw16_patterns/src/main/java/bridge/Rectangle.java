package bridge;

class Rectangle implements Shape {
    private final Color color;

    public Rectangle(Color color) {
        this.color = color;
    }

    public void draw() {
        System.out.print("Draw a rectangle ");
        color.fill();
    }
}
