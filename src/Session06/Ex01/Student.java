package Session06.Ex01;

public class Student {
    private String id;
    private String name;
    private int age;
    private int avgScore;

    public Student(String id, String name, int age, int avgScore) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.avgScore = avgScore;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Average Score: " + this.avgScore);
    }

    public static void main(String[] args) {
        Student student1 = new Student("S001", "Alice", 20, 85);
        Student student2 = new Student("S002", "Bob", 22, 90);

        student1.displayInfo();
        System.out.println();
        student2.displayInfo();
    }
}
