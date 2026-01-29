package Session05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MiniProject {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = getInt("Nhập lựa chọn: ");

            switch (choice) {
                case 1:
                    twoSum();
                    break;
                case 2:
                    moveZeroes();
                    break;
                case 3:
                    validPalindrome();
                    break;
                case 4:
                    reverseWords();
                    break;
                case 5:
                    happyNumber();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    // ================= MENU =================
    static void showMenu() {
        System.out.println("\n========= MENU =========");
        System.out.println("1. [FR1] Two Sum");
        System.out.println("2. [FR2] Move Zeroes");
        System.out.println("3. [FR3] Valid Palindrome");
        System.out.println("4. [FR4] Reverse Words");
        System.out.println("5. [FR5] Happy Number");
        System.out.println("0. Thoát");
        System.out.println("========================");
    }

    // ================= UTILS =================
    static int getInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Nhập số hợp lệ: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    static int[] inputArray() {
        int n = getInt("Nhập số phần tử: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = getInt("arr[" + i + "] = ");
        }
        return arr;
    }

    // ================= FR1: TWO SUM =================
    static void twoSum() {
        int[] arr = inputArray();
        int target = getInt("Nhập target: ");

        boolean found = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.printf("Tìm thấy cặp chỉ số: [%d, %d] (giá trị: %d + %d = %d)\n", i, j, arr[i], arr[j],
                            arr[i] + arr[j]);
                    found = true;
                    return;
                }
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy cặp nào");
        }
    }

    // ================= FR2: MOVE ZEROES =================
    static void moveZeroes() {
        int[] arr = inputArray();
        int index = 0;

        for (int num : arr) {
            if (num != 0) {
                arr[index++] = num;
            }
        }

        while (index < arr.length) {
            arr[index++] = 0;
        }

        System.out.println("Mảng sau khi dồn 0:");
        System.out.println(Arrays.toString(arr));
    }

    // ================= FR3: VALID PALINDROME =================
    static void validPalindrome() {
        System.out.print("Nhập chuỗi: ");
        scanner.nextLine();
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Chuỗi là Palindrome");
        } else {
            System.out.println("Chuỗi không phải Palindrome");
        }
    }

    public static boolean isPalindrome(String str) {
        String validateString = str
                .replaceAll("[^a-zA-Z]", "")
                .toLowerCase();

        int len = validateString.length();
        for (int i = 0; i < len / 2; i++) {
            if (validateString.charAt(i) != validateString.charAt(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    // ================= FR4: REVERSE WORDS =================

    public static void reverseWords() {
        System.out.print("Nhập chuỗi: ");
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] text = s.trim().split("\\s+");
        String result = "";
        for (int i = text.length - 1; i >= 0; i--) {
            result += text[i] + " ";
        }
        System.out.println("Kết quả: " + result.trim());
    }

    // ================= FR5: HAPPY NUMBER =================
    static void happyNumber() {
        int n = getInt("Nhập số n: ");

        if (atminHappy(n)) {
            System.out.println("Là số hạnh phúc");
        } else {
            System.out.println("Không phải số hạnh phúc");
        }
    }

    static boolean atminHappy(int n) {
        HashSet<Integer> temp = new HashSet<>();

        while (n != 1) {
            if (temp.contains(n))
                return false;

            temp.add(n);
            n = sumOfSquares(n);
        }
        return true;
    }

    static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    // ================= FR5: HAPPY NUMBER SIMPLE =================
    static void happyNumberSimple() {
        int n = getInt("Nhập số n: ");

        if (isHappy(n)) {
            System.out.println("Là số hạnh phúc");
        } else {
            System.out.println("Không phải số hạnh phúc");
        }
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        // Chạy cho đến khi Thỏ đuổi kịp Rùa hoặc Thỏ chạm đích (số 1)
        while (fast != 1 && slow != fast) {
            slow = getNext(slow); // Rùa đi 1 bước
            fast = getNext(getNext(fast)); // Thỏ đi 2 bước
        }
        // Nếu dừng lại vì fast == 1 thì là số hạnh phúc
        return fast == 1;
    }

    // Hàm tính tổng bình phương các chữ số
    public static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            totalSum += d * d;
            n = n / 10;
        }
        return totalSum;
    }
}