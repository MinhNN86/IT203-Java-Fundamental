package Session01;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhập số ngày trả trễ: ");
            int ngayTraTre = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Nhập số lượng sách mượn: ");
            int soLuongSachMuon = Integer.parseInt(sc.nextLine().trim());

            double tienPhatGoc = ngayTraTre * soLuongSachMuon * 5000;
            double tienPhatDieuChinh = tienPhatGoc;

            if (ngayTraTre > 7 && soLuongSachMuon >= 3) {
                tienPhatDieuChinh = tienPhatGoc * 1.2;
            }

            boolean khoaThe = tienPhatDieuChinh > 50000;

            System.out.printf("Tiền phạt gốc: %.2f%n", tienPhatGoc);
            System.out.printf("Tiền phạt điều chỉnh: %.2f%n", tienPhatDieuChinh);
            System.out.printf("Yêu cầu khóa thẻ: %b%n", khoaThe);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập một số hợp lệ.");
        }
    }
}