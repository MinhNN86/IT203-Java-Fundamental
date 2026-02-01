package Session07.Ex01;

public class Student {
    private String studentId;
    private String studentName;

    private static int studentCount = 0;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        studentCount++;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Student Name: " + this.studentName);
    }

    public static void displayStudentCount() {
        System.out.println("Total Students: " + studentCount);
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public static void main(String[] args) {
        Student student1 = new Student("S001", "Alice");
        Student student2 = new Student("S002", "Bob");

        student1.displayInfo();
        System.out.println();
        student2.displayInfo();
        System.out.println();
        Student.displayStudentCount();
    }
}
