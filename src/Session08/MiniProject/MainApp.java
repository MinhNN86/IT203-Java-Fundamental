package Session08.MiniProject;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm sinh viên");
            System.out.println("4. Cập nhật sinh viên");
            System.out.println("5. Xóa sinh viên");
            System.out.println("6. Sắp xếp theo điểm");
            System.out.println("7. Thống kê");
            System.out.println("8. Thoát");
            System.out.print("Chọn: ");

            while (!sc.hasNextInt()) {
                System.out.print("Lựa chọn không hợp lệ! Vui lòng nhập lại: ");
                sc.next();
            }
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    sm.themSinhVien();
                    break;
                case 2:
                    sm.hienThiDanhSach();
                    break;
                case 3:
                    sm.timSinhVien();
                    break;
                case 4:
                    sm.capNhatSinhVien();
                    break;
                case 5:
                    sm.xoaSinhVien();
                    break;
                case 6:
                    sm.sapXepTheoDiem();
                    break;
                case 7:
                    sm.thongKe();
                    break;
                case 8:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 8);

        sc.close();
    }

}
