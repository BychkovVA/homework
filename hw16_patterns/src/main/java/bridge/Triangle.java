package bridge;

class Triangle implements Shape {
    private final Color color;

    public Triangle(Color color) {
        this.color = color;
    }

    public void draw() {
        System.out.print("Draw a triangle ");
        color.fill();
    }
}
