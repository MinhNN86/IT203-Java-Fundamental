package Session09.Ex01;

public class Student extends Person {
    private String studentId;
    private double averageScore;

    public Student(String fullName, int age, String studentId, double averageScore) {
        super(fullName, age);
        this.studentId = studentId;
        this.averageScore = averageScore;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Mã sinh viên: " + studentId);
        System.out.println("Điểm trung bình: " + averageScore);
    }
}

