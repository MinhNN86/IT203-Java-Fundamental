package Session12.onTap.Ex02;

import java.util.Scanner;

public class P2 {
    public static void sapXepViTri(int[] arr, int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
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
        sapXepViTri(arr, n);
        System.out.println("Mảng sau khi phân tách chẵn lẻ:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
