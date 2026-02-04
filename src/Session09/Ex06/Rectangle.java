package Session09.Ex06;

public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double side) {
        this(side, side);
    }

    @Override
    public double area() {
        return width * height;
    }
}