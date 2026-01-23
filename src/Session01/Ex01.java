package Session01;

import java.util.Scanner;
import java.time.Year;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sách: ");
        String bookID = sc.nextLine();

        System.out.print("Nhập tên sách: ");
        String bookName = sc.nextLine();

        System.out.print("Nhập năm xuất bản: ");
        int publishYear = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập giá sách: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Sách còn trong kho? (true/false): ");
        boolean isAvailable = Boolean.parseBoolean(sc.nextLine());

        int currentYear = Year.now().getValue();
        int bookAge = currentYear - publishYear;

        System.out.println("\n--- PHIẾU THÔNG TIN SÁCH ---");
        System.out.println("Tên sách: " + bookName.toUpperCase());
        System.out.printf("Mã số: %s | Tuổi thọ: %d năm\n", bookID, bookAge);
        System.out.printf("Giá bán: %.2f\n", price);

        if (isAvailable) {
            System.out.println("Tình trạng: Còn sách");
        } else {
            System.out.println("Tình trạng: Không còn");
        }

        sc.close();
    }
}
