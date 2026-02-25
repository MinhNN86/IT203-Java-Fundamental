package Session12.Hackathon.Ex01;

import java.util.Arrays;
import java.util.Scanner;

public class P2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi ký tự hỗn hợp: ");
        String input = sc.nextLine();

        String[] compile = input.split("\\s+");
        StringBuffer tuHopLe = new StringBuffer();

        System.out.println(Arrays.toString(compile));

        for (String word : compile) {
            if (word.matches("[a-zA-Z]+")) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                tuHopLe.append(capitalizedWord).append(" ");
            }
        }

        System.out.println(tuHopLe);
    }
}
