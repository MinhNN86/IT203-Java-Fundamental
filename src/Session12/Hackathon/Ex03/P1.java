package Session12.Hackathon.Ex03;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập mảng A
        System.out.print("Nhập vào số phần tử của mảng A: ");
        int soLuongPhanTuA = sc.nextInt();
        int[] a = new int[soLuongPhanTuA];

        System.out.println("Nhập vào các phần tử của mảng:");
        for (int i = 0; i < soLuongPhanTuA; i++) {
            System.out.print("arr[" + i + "]: ");
            a[i] = sc.nextInt();
        }

        // Nhập mảng B
        System.out.print("Nhập vào số phần tử của mảng B: ");
        int soLuongPhanTuB = sc.nextInt();
        int[] b = new int[soLuongPhanTuB];

        System.out.println("Nhập vào các phần tử của mảng:");
        for (int i = 0; i < soLuongPhanTuB; i++) {
            System.out.print("arr[" + i + "]: ");
            b[i] = sc.nextInt();
        }

        // Mảng lưu kết quả đã lọc
        int[] result = new int[soLuongPhanTuA];
        int indexResult = 0;

        // Lọc các phần tử
        for (int i = 0; i < soLuongPhanTuA; i++) {
            boolean isUniqueInA = true;
            for (int j = 0; j < soLuongPhanTuA; j++) {
                if (i != j && a[i] == a[j]) {
                    isUniqueInA = false;
                    break;
                }
            }

            boolean isInB = false;
            for (int k = 0; k < soLuongPhanTuB; k++) {
                if (a[i] == b[k]) {
                    isInB = true;
                    break;
                }
            }

            if (isUniqueInA && !isInB) {
                result[indexResult++] = a[i];
            }
        }

        // In kết quả
        for (int i = 0; i < indexResult; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}
