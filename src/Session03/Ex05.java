package Session03;

import java.util.Arrays;
import java.util.Scanner;

public class Ex05 {
    public static int deleteBook(int[] arr, int n, int bookId){
        int indexBookDelete = -1;
        for(int i = 0; i < n; i++){
            if(arr[i] == bookId){
                indexBookDelete = i;
                break;
            }
        }

        if(indexBookDelete == -1){
            System.out.println("Không tìm thấy id sách");
            return n;
        }

        for(int i = indexBookDelete; i < n - 1; i++){
            arr[i] = arr[i + 1];
        }

        System.out.println("Đã xóa sách mã " + bookId);
        return n - 1;
    }

    public static void displayBooks(int[] arr, int n){
        if(n == 0){
            System.out.println("Kho sách rống!");
            return;
        }

        System.out.printf("Kho sách hiện tại (%d cuốn): [", n);
        for(int i = 0; i < n; i++){
            System.out.printf(" %d ", arr[i]);
            if(i == n - 1){
                System.out.println("]");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] books = {101, 203, 305, 407, 509};
        int n = books.length;

        while (true){
            displayBooks(books, n);

            if(n == 0){
                break;
            }

            System.out.print("Nhập mã sách cần xoá (0 để thoát): ");
            int bookId = Integer.parseInt(sc.nextLine());

            if(bookId == 0){
                break;
            }

            n = deleteBook(books, n, bookId);
        }

        sc.close();
    }
}
