package Session01;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập giá sách (USD - double): ");
        double giaSachUSD = Double.parseDouble(sc.nextLine());

        double giaSachVND = giaSachUSD * 25450;

        long giaSachVNDLamTron = (long) giaSachVND;

        System.out.println("Giá chính xác (số thực): " + giaSachVND );
        System.out.println("Giá làm tròn để thanh toán (long): " + giaSachVNDLamTron);

        sc.close();
    }
}
