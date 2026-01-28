package Session04;

import java.util.regex.Pattern;

public class Ex04 {
    public static void main(String[] args) {
        String cardID = "TV202312345";

        checkCard(cardID);
    }

    public static void checkCard(String code) {
        String fullRegex = "^TV\\d{4}\\d{5}$";

        // Kiểm tra tiền tố
        if (!code.startsWith("TV")) {
            System.out.println("Thiếu tiền tố TV");
            return;
        }

        // Kiểm tra năm (4 chữ số sau TV)
        if (code.length() < 6 || !code.substring(2, 6).matches("\\d{4}")) {
            System.out.println("Năm không hợp lệ");
            return;
        }

        // Kiểm tra toàn bộ định dạng
        if (!Pattern.matches(fullRegex, code)) {
            System.out.println("Định dạng mã thẻ không hợp lệ");
            return;
        }

        // Nếu đúng hết
        System.out.println("Mã thẻ hợp lệ");
    }
}
