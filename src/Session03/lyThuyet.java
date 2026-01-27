package Session03;

import java.util.Arrays;

public class lyThuyet {
    public static void main(String[] args) {
        // Định nghĩa mảng 1 chiều
        int[] arrInt = new int[5];
        String[] arrStr = new String[10];
        System.out.println("Độ dài của mảng arrInt: " + arrInt.length);
        System.out.println("Độ dài của mảng arrStr: " + arrStr.length);

        // Giá trị các phần tử
        System.out.println(Arrays.toString(arrInt));
        System.out.println(Arrays.toString(arrStr));

        // Khai báo và khởi tạo giá trị cho mảng: Khởi tạo trực tiếp: array literal
        int[] arrInteger = { 10, 20, 30, 40, 50 };
        System.out.println(Arrays.toString(arrInteger));

        // Truy xuất phần tử
        System.out.println("Phần tử tại vị trí index = 3 là " + arrInteger[3]);
        // Thay đổi giá trị
        arrInteger[3] = 100;
        System.out.println("Phần tử tại vị trí index = 3 sau khi thay đổi là " + arrInteger[3]);

        // Thao tác duyệt qua các phần tử của mảng 1 chiều
        // duyệt qua vòng lặp for
        for (int i = 0; i < arrInteger.length; i++) {
            System.out.printf("arrInteger[%d] = %d%n", i, arrInteger[i]);
        }

        // Duyệt qua for-each
        for (int element : arrInteger) {
            System.out.println("Giá trị phần tử element = " + element);
        }

    }

    // Phương thức trong Java
    // modifier returnType methodName(parameterList) {
    // body method
    // return value; // nếu có giá trị trả về
    // }
    // modifier: public, private, protected, default
    // returnType: kiểu dữ liệu trả về: int, double, String, void (không trả về gì)
    // methodName: tên phương thức
    // parameterList: danh sách tham số (có thể không có tham số)
}
