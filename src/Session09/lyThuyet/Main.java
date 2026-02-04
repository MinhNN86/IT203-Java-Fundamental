package Session09.lyThuyet;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();

        // Ép kiểu
        // Ép kiểu ngầm định
        Animal animal = cat; // Kiểu khai báo là Animal, nhưng kiểu thực tế là Cat
        Animal dog = new Dog();
        // Toán tử instanceof
        if (cat instanceof Animal) {
            Cat jerry = (Cat) animal; // Ép kiểu tường minh từ Animal về Cat: Có thể sinh ra lỗi
        }
        if (dog instanceof Cat) {
            Cat dog1 = (Cat) dog;
        }

        // Nạp chồng phương thức
        Caculator caculator = new Caculator();
        int sum1 = caculator.sum(2, 3);
        int sum2 = caculator.sum(2, 3, 4);
        double sum3 = caculator.sum(2.5, 3.5);
    }
}
