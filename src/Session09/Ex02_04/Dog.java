package Session09.Ex02_04;

public class Dog extends Animal {

    @Override
    public void sound() {
        System.out.println("Chó sủa: Gâu gâu");
    }

    // Phương thức riêng của Dog
    public void fetch() {
        System.out.println("Chó đi tìm đồ vật!");
    }
}
