package Session12.onTap.Ex01;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập một chuỗi: ");
        String input = sc.nextLine();

        int[] charCount = new int[26];
        input = input.toLowerCase();

        // B1: Đếm số lần xuất hiện của mỗi ký tự
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                charCount[ch - 'a']++;
            }
        }

        // B2: Tìm ký tự xuất hiện nhiều nhất ( xuất hiện đầu tiên )
        int maxCount = 0;
        char maxChar = 0;
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                int currentCount = charCount[ch - 'a'];

                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxChar = ch;
                }
            }
        }

        System.out.println("Ký tự xuất hiện nhiều nhất: " + maxChar);

    }
}
