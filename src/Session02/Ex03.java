package Session02;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng sách trả muộn: ");
        int n = Integer.parseInt(sc.nextLine());

        int total = 0;
        final int FINE_PER_DAY = 5000;
        for (int i = 1; i <= n; i++) {
            System.out.printf("Nhập số ngày trễ của cuốn thứ %d: ", i);
            int daysLate = Integer.parseInt(sc.nextLine());
            total += daysLate * FINE_PER_DAY;
        }
        System.out.printf("===> Tổng tiền phạt: %d VND%n", total);

        sc.close();
    }
}
