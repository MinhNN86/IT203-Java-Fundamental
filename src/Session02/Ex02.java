package Session02;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char choice;
        do {
            System.out.print("Nhap ma kh vuc (A, B, C, D): ");
            choice = sc.nextLine().toUpperCase().charAt(0);
            switch (choice) {
                case 'A':
                    System.out.println("Vi tri: Tang 1 - Sach Van Hoc");
                    break;
                case 'B':
                    System.out.println("Vi tri: Tang 2 - Sach Khoa Hoc");
                    break;
                case 'C':
                    System.out.println("Vi tri: Tang 3 - Sach Ngoai Ngu");
                    break;
                case 'D':
                    System.out.println("Vi tri: Tang 4 - Sach Tin Hoc");
                    break;
                default:
                    System.out.println("Loi: Ma khu vuc khong hop le");

            }
        } while (choice < 'A' || choice > 'D');

        sc.close();
    }
}
