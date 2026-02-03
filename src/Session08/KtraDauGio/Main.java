import java.util.Scanner;

public class Main {
    static Student[] students = new Student[100];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    inputStudents(sc);
                    break;
                case 2:
                    showStudents();
                    break;
                case 3:
                    searchByRank(sc);
                    break;
                case 4:
                    sortByScoreDesc();
                    System.out.println("Da sap xep xong!");
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 5);
    }

    public static void displayMenu() {
        System.out.println("===== QUAN LY DIEM SINH VIEN =====");
        System.out.println("1. Nhap danh sach sinh vien");
        System.out.println("2. Hien thi danh sach sinh vien");
        System.out.println("3. Tim kiem sinh vien theo hoc luc");
        System.out.println("4. Sap xep theo hoc luc giam dan");
        System.out.println("5. Thoat");
        System.out.print("Chon chuc nang: ");
    }

    static void inputStudents(Scanner sc) {
        System.out.print("Nhap so luong sinh vien: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ":");
            String id;

            while (true) {
                System.out.print("Nhap ma SV (VD: SV001): ");
                id = sc.nextLine();
                if (id.matches("SV\\d{3}")) {
                    break;
                } else {
                    System.out.println("Ma sinh vien KHONG hop le!");
                }
            }

            System.out.print("Nhap ho ten: ");
            String name = sc.nextLine();

            System.out.print("Nhap diem: ");
            double score = sc.nextDouble();
            sc.nextLine();

            students[count++] = new Student(id, name, score);
        }
    }

    static void showStudents() {
        if (count == 0) {
            System.out.println("Danh sach rong!");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(students[i].toString());
        }
    }

    static void searchByRank(Scanner sc) {
        System.out.print("Nhap hoc luc can tim (Gioi/Kha/Trung Binh): ");
        String rank = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (students[i].getRank().equalsIgnoreCase(rank)) {
                System.out.println(students[i].toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sinh vien nao");
        }
    }

    static void sortByScoreDesc() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (students[i].getScore() < students[j].getScore()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

}