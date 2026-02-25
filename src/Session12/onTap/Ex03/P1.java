package Session12.onTap.Ex03;

import java.util.Scanner;

public class P1 {
    public static void timGiao(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        // Mảng lưu kết quả
        int[] result = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean found = false;

            for (int j = 0; j < m; j++) {
                if (A[i] == B[j]) {
                    found = true;
                    break;
                }
            }

            if (found) {
                boolean alreadyInResult = false;
                for (int k = 0; k < count; k++) {
                    if (A[i] == result[k]) {
                        alreadyInResult = true;
                        break;
                    }
                }
                if (!alreadyInResult) {
                    result[count] = A[i];
                    count++;
                }
            }

        }

        System.out.println("Các phần tử chung giữa A và B:");
        for (int i = 0; i < count; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số phần tử mảng A
        System.out.print("Nhập số phần tử mảng A: ");
        int n = sc.nextInt();
        int[] A = new int[n];

        System.out.println("Nhập các phần tử của mảng A:");
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "] = ");
            A[i] = sc.nextInt();
        }

        // Nhập số phần tử mảng B
        System.out.print("Nhập số phần tử mảng B: ");
        int m = sc.nextInt();
        int[] B = new int[m];

        System.out.println("Nhập các phần tử của mảng B:");
        for (int i = 0; i < m; i++) {
            System.out.print("B[" + i + "] = ");
            B[i] = sc.nextInt();
        }

        // Tìm giao của A và B
        timGiao(A, B);
    }
}
