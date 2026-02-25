package Session12.Hackathon.Ex02;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập mảng
        System.out.print("Nhập vào số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập vào các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "]: ");
            arr[i] = sc.nextInt();
        }

        int currentCount = 1;
        int maxCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }

        System.out.println("Độ dài dãy tăng liên tiếp dài nhất: " + maxCount);
        sc.close();
    }
}
