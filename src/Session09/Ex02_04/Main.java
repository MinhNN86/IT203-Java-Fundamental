package Session09.Ex02_04;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        animal1.sound();
        animal2.sound();

        // Ex04:
        // Khai báo Animal animal = new Dog();
        Animal animal = new Dog();

        // Gọi phương thức chung
        animal.sound(); // sẽ gọi phương thức override của Dog

        // Thử gọi phương thức riêng của Dog (fetch)
        // animal.fetch(); // Lỗi: Animal không có phương thức fetch

        // Sử dụng instanceof và ép kiểu để gọi phương thức riêng
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.fetch(); // Gọi được phương thức riêng của Dog
        }
    }
}
