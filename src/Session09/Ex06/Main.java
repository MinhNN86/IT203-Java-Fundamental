package Session09.Ex06;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(2.0);
        shapes[1] = new Rectangle(3.0, 4.0);
        shapes[2] = new Circle(); // default radius
        shapes[3] = new Rectangle(5.0); // square

        double totalArea = 0;
        for (Shape s : shapes) {
            totalArea += s.area();
        }
        System.out.println("Total area: " + totalArea);
    }
}