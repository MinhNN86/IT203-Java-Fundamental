package Session10.lyThuyet;

public class Rectangle extends Shape{
    private double width, height;


    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2*(width + height);
    }
}
