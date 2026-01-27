package Session03;

import java.util.Arrays;

public class Ex04 {
    public static void sortBooks(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void displayBooks(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] bookCodes = { 105, 23, 87, 12, 99, 45 };

        System.out.print("Trước khi sắp xếp: ");
        displayBooks(bookCodes);
        System.out.println();
        sortBooks(bookCodes);
        System.out.print("Sau khi sắp xếp: ");
        displayBooks(bookCodes);
    }
}
