package Session12.Hackathon.Ex01;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi ký tự hỗn hợp: ");
        String input = sc.nextLine();

        String[] compile = input.split("\\s+");
        int tuHopLe = 0;
        for (String word : compile) {
            if (word.matches("[a-zA-Z]+")) {
                tuHopLe++;
            }
        }

        System.out.println("Số từ hợp lệ: " + tuHopLe);

    }
}
