package Session07;

public class lyThuyet {

    public static void main(String[] args) {

        Student s1 = new Student("Alice", 1);

        Student s2 = new Student("Bob", 2);

        // Truy cập biến static qua tên lớp (khuyến khích)

        System.out.println("Total students: " + Student.getTotalStudents());

        // Truy cập biến instance qua đối tượng

        s1.displayInfo();

    }

}

class Student {

    // Biến của đối tượng - mỗi sinh viên có giá trị riêng
    private String name; // Tên sinh viên
    private int id; // Mã sinh viên
    private double gpa; // Điểm trung bình

    // Biến của lớp - chung cho tất cả sinh viên
    private static String schoolName = "ABC University"; // Tên trường
    private static int totalStudents = 0; // Tổng số sinh viên

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        totalStudents++; // Tăng biến static khi tạo sinh viên mới
    }

    public void displayInfo() {
        // Truy cập biến instance
        System.out.println("Name: " + name);
        // Truy cập biến static (có thể dùng trực tiếp trong lớp)
        System.out.println("School: " + schoolName);
    }

    // Getter cho biến static
    public static int getTotalStudents() {
        return totalStudents;
    }
}