package Session12.onTap.Ex02;

import java.util.Scanner;

public class P1 {
    public static int deleteElement(int[] arr, int n, int x) {
        int k = 0; // vị trí ghi phần tử tiếp theo không bằng x
        for (int i = 0; i < n; i++) {
            if (arr[i] != x) {
                arr[k] = arr[i];
                k++;
            }
            // nếu arr[i] == x thì bỏ qua (về cơ bản "xóa" nó bằng cách không ghi)
        }
        return k; // kích thước mới
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Nhập các phần tử của mảng
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "]: ");
            arr[i] = sc.nextInt();
        }

        // Nhập giá trị cần xóa
        System.out.print("Nhập giá trị cần xóa: ");
        int valueToRemove = sc.nextInt();

        int newSize = deleteElement(arr, n, valueToRemove);
        for (int i = 0; i < newSize; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("(Kích thước mới của mảng: " + newSize + ")");
    }

}
