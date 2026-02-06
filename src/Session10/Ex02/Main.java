package Session10.Ex02;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota");
        Vehicle bicycle = new Bicycle("Thống nhất");

        System.out.println("Xe hơi:");
        car.move();
        System.out.println();

        System.out.println("Xe đạp:");
        bicycle.move();
    }
}
