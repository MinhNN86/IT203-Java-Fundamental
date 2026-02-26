package Session13.Ex05;

import java.util.*;

public class Main {
    static ArrayList<Patient> patientList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== HỆ THỐNG QUẢN LÝ HỒ SƠ BỆNH ÁN =====");
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("2. Cập nhật chẩn đoán");
            System.out.println("3. Xuất viện");
            System.out.println("4. Sắp xếp danh sách");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    updateDiagnosis();
                    break;
                case 3:
                    dischargePatient();
                    break;
                case 4:
                    sortPatients();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // 1. Tiếp nhận bệnh nhân
    public static void addPatient() {
        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();

        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                System.out.println("ID đã tồn tại!");
                return;
            }
        }

        System.out.print("Nhập họ tên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = scanner.nextLine();

        patientList.add(new Patient(id, name, age, diagnosis));
        System.out.println("Thêm bệnh nhân thành công!");
    }

    // 2. Cập nhật chẩn đoán
    public static void updateDiagnosis() {
        System.out.print("Nhập ID bệnh nhân: ");
        String id = scanner.nextLine();

        for (Patient p : patientList) {
            if (p.getId().equals(id)) {
                System.out.print("Nhập chẩn đoán mới: ");
                String newDiagnosis = scanner.nextLine();
                p.setDiagnosis(newDiagnosis);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }

        System.out.println("Không tìm thấy bệnh nhân!");
    }

    // 3. Xuất viện
    public static void dischargePatient() {
        System.out.print("Nhập ID bệnh nhân: ");
        String id = scanner.nextLine();

        Iterator<Patient> iterator = patientList.iterator();
        while (iterator.hasNext()) {
            Patient p = iterator.next();
            if (p.getId().equals(id)) {
                iterator.remove();
                System.out.println("Xuất viện thành công!");
                return;
            }
        }

        System.out.println("Không tìm thấy bệnh nhân!");
    }

    // 4. Sắp xếp danh sách
    public static void sortPatients() {
        if (patientList.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        patientList.sort(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {

                // Tuổi giảm dần
                if (p2.getAge() != p1.getAge()) {
                    return p2.getAge() - p1.getAge();
                }

                // Nếu tuổi bằng nhau → tên A-Z
                return p1.getFullName().compareToIgnoreCase(p2.getFullName());
            }
        });

        System.out.println("\n--- DANH SÁCH SAU KHI SẮP XẾP ---");
        for (Patient p : patientList) {
            System.out.println(p);
        }
    }
}
