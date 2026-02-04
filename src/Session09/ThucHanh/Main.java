package Session09.ThucHanh;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== NHẬP THÔNG TIN CHIM =====");
        Bird bird = new Bird();
        bird.input();

        System.out.println("\n===== THÔNG TIN CHIM =====");
        bird.display();

        System.out.println("\n\n===== NHẬP THÔNG TIN ĐỘNG VẬT CÓ VÚ =====");
        MamalAnimal mamal = new MamalAnimal();
        mamal.input();

        System.out.println("\n===== THÔNG TIN ĐỘNG VẬT CÓ VÚ =====");
        mamal.display();
    }
}
