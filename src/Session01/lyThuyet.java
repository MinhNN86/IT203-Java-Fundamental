package Session01;

public class lyThuyet {
    public static void main(String[] args) {
        // Nhóm kiểm nguyên thủy: boolean, double, float, byte, short, int, long, char
        boolean isCheck = true;
        float f = 0.5f; // Kiểu float phải định nghĩa f phía sau giá trị
        double d = 1.5;
        char c = 'A';
        byte b = 10;
        short sh = 20000;
        int i = 1000000;
        long l = 11111111111L; // kiểu long phải định nghĩa L phía sau giá trị

        // Nhóm kiểu giữ liệu tham chiếu
        int[] arr = {1, 2, 3, 4}; // array
        String str = "12345";

        // Biến hằng
        final float PI = 3.14f;

        // Ép kiểu ngầm định
        int intValue = sh; // Không gây mất dữ liệu
        // Ép kiểu tường minh
        short shortValue = (short) i; // Có thể gây ra mất dữ liệu

        // Toán tử số học
        int sum = i + 100;
        sum++;
        sum--;
        sum -= 100;

        // Toán tử logic
        boolean check = i >= l;
        boolean isNegative = check && (shortValue%3==0);

    }
}
