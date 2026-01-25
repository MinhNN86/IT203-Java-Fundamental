package Session02;

import java.util.Scanner;

public class lyThuyet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // IF - ELSE
        System.out.print("Nhập số nguyên: ");
        int number = Integer.parseInt(sc.nextLine());
        if (number > 10) {
            System.out.println("Số number > 10");
        } else {
            System.out.println("Số number <= 10");
        }

        // IF-ELSE IF - ELSE
        if (number % 3 == 0) {
            System.out.println("number chia hết cho 3");
        } else if (number % 3 == 1) {
            System.out.println("number chia 3 dư 1");
        } else {
            System.out.println("number chia 3 dư 2");
        }

        // SWITCH CASE
        System.out.print("Nhập vào lựa chọn (1-5): ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Lựa chọn 1");
                break;
            case 2:
                System.out.println("Lựa chọn 2");
                break;
            case 3:
                System.out.println("Lựa chọn 3");
                break;
            case 4:
                System.out.println("Lựa chọn 4");
                break;
            case 5:
                System.out.println("Lựa chọn 5");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
                break;
        }

        // Vòng lặp FOR
        for (int i = 0, j = 10; i < 10; i++, j--) {
            System.out.printf("i = %d, j = %d%n", i, j);
        }
        // Vòng lặp lồng nhau
        for (int i = 0; i < 10; i++) {
            System.out.println("Vòng lặp thứ " + (i + 1));
            for (int j = 0; j < 5; j++) {
                System.out.printf("i = %d, j = %d%n", i, j);
            }
        }

        // Vòng lặp WHILE
        int number1 = 1;
        while (number1 != 0) {
            System.out.print("Nhập 1 số nguyên (0 để kết thúc): ");
            number1 = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Kết thúc vòng lặp WHILE");

        // Vòng lặp DO-WHILE
        int number2;
        do {
            System.out.print("Nhập 1 số nguyên (0 để kết thúc): ");
            number2 = Integer.parseInt(sc.nextLine());
        } while (number2 != 0);
        System.out.println("Kết thúc vòng lặp DO-WHILE");

        // Câu lệnh return
        // Gọi hàm
        printLoop();

    }

    // Câu lệnh Return
    public static void printLoop() {
        for (int i = 0; i < 50; i++) {
            if (i == 15) {
                return;
            }
            System.out.println("Giá trị của i: " + i);
        }
    }
}