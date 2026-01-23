package Session01;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thứ tự của sách trong hệ thống: ");
        int stt = Integer.parseInt(sc.nextLine());

        int ke = (stt - 1) / 25 + 1;
        int viTri = (stt - 1) % 25 + 1;
        String khuVuc = ke <= 10 ? "Khu cận" : "Khu Viễn";

        System.out.println("--- THÔNG TIN ĐỊNH VỊ ---");
        System.out.printf("Sách số: %d%n", stt);
        System.out.printf("Địa chỉ: Kệ %d - Vị trí %d%n", ke, viTri);
        System.out.printf("Phân khu: %s", khuVuc);
    }
}
