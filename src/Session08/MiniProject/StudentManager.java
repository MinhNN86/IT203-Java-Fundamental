package Session08.MiniProject;

import java.util.Scanner;

public class StudentManager {
    private Student[] students = new Student[100];
    private int count = 0;
    private Scanner sc = new Scanner(System.in);

    public void themSinhVien() {
        if (count >= students.length) {
            System.out.println("Danh sách đã đầy!");
            return;
        }
        System.out.print("Mã SV: ");
        String maSV = sc.nextLine();
        if (findStudentById(maSV) != -1) {
            System.out.println("Mã sinh viên đã tồn tại!");
            return;
        }
        System.out.print("Họ tên: ");
        String hoTen = sc.nextLine();
        System.out.print("Tuổi: ");
        int tuoi = Integer.parseInt(sc.nextLine());
        System.out.print("Giới tính: ");
        String gioiTinh = sc.nextLine();
        System.out.print("Điểm Toán: ");
        double diemToan = Double.parseDouble(sc.nextLine());
        System.out.print("Điểm Lý: ");
        double diemLy = Double.parseDouble(sc.nextLine());
        System.out.print("Điểm Hóa: ");
        double diemHoa = Double.parseDouble(sc.nextLine());
        students[count++] = new Student(maSV, hoTen, tuoi, gioiTinh, diemToan, diemLy, diemHoa);
        System.out.println("Thêm sinh viên thành công!");
    }

    public void hienThiDanhSach() {
        if (count == 0) {
            System.out.println("Danh sách sinh viên trống!");
            return;
        }
        System.out.printf("%-10s %-20s %-5s %-8s %-6s %-12s%n",
                "Mã SV", "Họ tên", "Tuổi", "GT", "ĐTB", "Xếp loại");
        for (int i = 0; i < count; i++) {
            students[i].displayInfo();
        }
    }

    public void timSinhVien() {
        System.out.print("Nhập mã hoặc tên: ");
        String key = sc.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getMaSV().equalsIgnoreCase(key) ||
                    students[i].getHoTen().toLowerCase().contains(key)) {
                if (!found) {
                    System.out.printf("Không tìm thấy sinh viên nào phù hợp.");
                }
                students[i].displayInfo();
                found = true;
            }
        }
    }

    public void capNhatSinhVien() {
        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        String maSV = sc.nextLine();
        int index = findStudentById(maSV);
        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên với mã đã cho.");
            return;
        }
        System.out.print("Tên mới: ");
        students[index].setHoTen(sc.nextLine());
        System.out.print("Tuổi mới: ");
        students[index].setTuoi(Integer.parseInt(sc.nextLine()));
        System.out.print("Điểm Toán: ");
        double diemtoan = Double.parseDouble(sc.nextLine());
        System.out.print("Điểm Lý: ");
        double diemly = Double.parseDouble(sc.nextLine());
        System.out.print("Điểm Hóa: ");
        double diemhoa = Double.parseDouble(sc.nextLine());
        students[index].setDiem(diemtoan, diemly, diemhoa);
        System.out.println("Cập nhật thành công!");
    }

    public void xoaSinhVien() {
        System.out.print("NHập mã SV cần xóa: ");
        String maSV = sc.nextLine();
        int idx = findStudentById(maSV);
        if (idx == -1) {
            System.out.println("Không tìm thấy!");
            return;
        }
        for (int i = idx; i < count - 1; i++) {
            students[i] = students[i + 1];
        }
        count--;
        System.out.println("Đã xóa sinh viên");
    }

    public void sapXepTheoDiem() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (students[j].getDiemTB() < students[j + 1].getDiemTB()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public void thongKe() {
        int gioi = 0, kha = 0, tb = 0, yeu = 0;
        for (int i = 0; i < count; i++) {
            switch (students[i].getXepLoai()) {
                case "Giỏi":
                    gioi++;
                    break;
                case "Khá":
                    kha++;
                    break;
                case "Trung bình":
                    tb++;
                    break;
                default:
                    yeu++;
            }
        }

        System.out.println("THỐNG KÊ");
        System.out.println("Giỏi: " + gioi);
        System.out.println("Khá: " + kha);
        System.out.println("Trung bình: " + tb);
        System.out.println("Yếu: " + yeu);
    }

    private int findStudentById(String maSV) {
        for (int i = 0; i < count; i++) {
            if (students[i].getMaSV().equalsIgnoreCase(maSV)) {
                return i;
            }
        }
        return -1;
    }
}
