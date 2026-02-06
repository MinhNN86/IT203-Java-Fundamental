package Session10.lyThuyet;

public class Main {
    public static void main(String[] args) {
        IColorable car = new Car();
        car.showColor(IColorable.RED);
        String code = car.getColorHexCode(IColorable.YELLOW);
        System.out.println(code);

        Shape circle1 = new Circle(5);
        System.out.println("Dien tich = " + circle1.calculateArea());
        System.out.println("Chu vi = " + circle1.calculatePerimeter());
    }
}
