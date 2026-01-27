package Session03;

import java.util.Scanner;

public class Ex02 {

    public static int searchBook(String[] arr, String search) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(search)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] books = {
                "Lap trinh Java",
                "Cau truc du lieu",
                "Giai thuat",
                "Clean Code",
                "Design Patterns"
        };

        System.out.print("Nhập tên sách cần tìm: ");
        String searchBook = sc.nextLine();

        int index = searchBook(books, searchBook);
        if (index != -1) {
            System.out.printf("Tìm thấy sách '%s' tại vị trí số: %d\n", searchBook, index);
        } else {
            System.out.println("Sách không tồn tại trong thư viện.");
        }

        sc.close();
    }
}
