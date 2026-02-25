package Session12.Hackathon.sEx02;

import java.util.Scanner;

public class P2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        System.out.println("Nhập vào các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "]: ");
            arr[i] = sc.nextInt();
        }

        // Nhập dữ liệu chèn
        System.out.print("x = ");
        int x = sc.nextInt();

        System.out.print("index = ");
        int index = sc.nextInt();
        if (index < 0 || index > n) {
            System.out.println("Vị trí chèn không hợp lệ!");
            sc.close();
            return;
        }

        // Chèn phần tử
        for (int i = n; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        n++;
        arr[index] = x;

        // In kết quả
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
