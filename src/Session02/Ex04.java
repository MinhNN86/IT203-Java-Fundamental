package Session02;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int idBook;
        do {
            System.out.print("Nhập mã ID sách mới (phải lớn hơn 0): ");
            idBook = Integer.parseInt(sc.nextLine());
            if (idBook > 0) {
                System.out.printf("Xác nhận: Mã sách %d đã được ghi nhận.\n", idBook);
            } else {
                System.out.println("Lỗi: ID phải là số dương. Mời nhập lại!");
            }
        } while (idBook <= 0);
        sc.close();
    }
}
