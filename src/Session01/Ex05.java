package Session01;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sách (4 chữ số): ");
        int code = Integer.parseInt(sc.nextLine());

        int thousands = code / 1000;
        int hundreds = ( code / 100 ) % 10;
        int dozens = ( code / 10 ) % 10;
        int units = code % 10;

        int sumOfFirstThreeNumber = thousands + hundreds + dozens;
        String displayCheckValue;
        if((sumOfFirstThreeNumber % 10) == units){
            displayCheckValue = "HỢP LỆ";
        } else {
            displayCheckValue = "SAI MÃ";
        }

        System.out.println("Chữ số kiểm tra kỳ vọng: " + units);
        System.out.println("Kết quả kiểm tra mã sách: " + displayCheckValue );
        sc.close();
    }
}
