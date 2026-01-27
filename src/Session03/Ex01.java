package Session03;

import java.util.Scanner;

public class Ex01 {
    public static int[] addBookToLibraries(int n, Scanner sc) {
        int[] books = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Sách thứ %d: ", i + 1);
            books[i] = sc.nextInt();
        }
        return books;
    }

    public static void displayBooks(int[] arr) {
        System.out.print("Danh sách mã sách: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng sách cần thêm vào thư viện: ");
        int n = sc.nextInt();

        System.out.printf("Nhập mã số cho %d cuốn sách:%n", n);
        int[] books = addBookToLibraries(n, sc);

        displayBooks(books);

        sc.close();
    }
}
