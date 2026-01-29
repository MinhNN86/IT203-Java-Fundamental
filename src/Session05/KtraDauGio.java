package Session05;

import java.util.Scanner;

public class KtraDauGio {
    static final int MAX = 100;
    static String[] studentIDs = new String[MAX];
    static int size = 0;
    static final String MSSV_regex = "^B\\d{7}$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            showMenu();
            System.out.print("Chọn chức năng (1-6): ");
            choice = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (choice) {
                case 1:
                    displayStudent();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

        } while (choice != 6);
        scanner.close();
    }

    static void showMenu() {
        System.out.println("\n===== QUẢN LÝ MSSV =====");
        System.out.println("1. Hiển thị danh sách");
        System.out.println("2. Thêm mới MSSV");
        System.out.println("3. Cập nhật MSSV");
        System.out.println("4. Xóa MSSV");
        System.out.println("5. Tìm kiếm MSSV");
        System.out.println("6. Thoát");
    }

    static void displayStudent() {
        if (size == 0) {
            System.out.println("Danh sách MSSV rỗng.");
        } else {
            System.out.println("Danh sách MSSV:");
            for (int i = 0; i < size; i++) {
                System.out.printf("%d. %s\n", (i + 1), studentIDs[i]);
            }
        }
    }

    static void searchStudent() {
        if (size == 0) {
            System.out.println("Danh sách MSSV rỗng. Không có MSSV nào để tìm kiếm.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập MSSV cần tìm (định dạng Bxxxxxxx): ");
        String searchID = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (studentIDs[i].equals(searchID)) {
                System.out.printf("Tìm thấy MSSV (%s) tại vị trí %d.\n", searchID, (i));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy MSSV \"" + searchID + "\" trong danh sách.");
        }
    }

    static void addStudent() {
        if (size >= MAX) {
            System.out.println("Danh sách MSSV đã đầy. Không thể thêm mới.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập MSSV mới (định dạng Bxxxxxxx): ");
        String newID = sc.nextLine();

        for (int i = 0; i < size; i++) {
            if (studentIDs[i].equals(newID)) {
                System.out.printf("MSSV %s đã tồn tại. Vui lòng nhập MSSV khác.\n", newID);
                return;
            }
        }

        if (newID.matches(MSSV_regex)) {
            studentIDs[size++] = newID;
            System.out.println("Thêm MSSV thành công.");
        } else {
            System.out.println("MSSV không hợp lệ. Vui lòng nhập lại.");
        }
    }

    static void updateStudent() {
        if (size == 0) {
            System.out.println("Danh sách MSSV rỗng. Không có MSSV nào để cập nhật.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vị trí MSSV cần cập nhật (1-" + size + "): ");
        int index = Integer.parseInt(sc.nextLine()) - 1;
        if (index < 0 || index >= size) {
            System.out.println("Vị trí không hợp lệ.");
            return;
        }

        System.out.println("MSSV hiện tại: " + studentIDs[index]);
        System.out.print("Nhập MSSV mới (định dạng Bxxxxxxx): ");
        String newID = sc.nextLine();

        for (int i = 0; i < size; i++) {
            if (i != index && studentIDs[i].equals(newID)) {
                System.out.printf("MSSV %s đã tồn tại. Vui lòng nhập MSSV khác.\n", newID);
                return;
            }
        }

        if (newID.matches(MSSV_regex)) {
            studentIDs[index] = newID;
            System.out.println("Cập nhật MSSV thành công.");
        } else {
            System.out.println("MSSV không hợp lệ. Vui lòng nhập lại.");
        }
    }

    static void deleteStudent() {
        if (size == 0) {
            System.out.println("Danh sách MSSV rỗng. Không có MSSV nào để xóa.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vị trí MSSV cần xóa (1-" + size + "): ");
        int index = Integer.parseInt(sc.nextLine()) - 1;

        if (index < 0 || index >= size) {
            System.out.println("Vị trí không hợp lệ.");
            return;
        }

        System.out.println("MSSV sẽ bị xóa: " + studentIDs[index]);

        for (int i = index; i < size - 1; i++) {
            studentIDs[i] = studentIDs[i + 1];
        }
        size--;
        System.out.println("Xóa MSSV thành công.");

    }
}
