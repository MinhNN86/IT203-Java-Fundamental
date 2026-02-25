package Session12.onTap.Ex01;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập một chuỗi: ");
        String input = sc.nextLine();

        StringBuilder vowels = new StringBuilder();
        StringBuilder consonants = new StringBuilder();

        input = input.toLowerCase();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels.append(ch);
                } else {
                    consonants.append(ch);
                }
            }
        }

        System.out.println("Nguyên âm: " + vowels.toString());
        System.out.println("Phụ âm: " + consonants.toString());

        sc.close();
    }
}
