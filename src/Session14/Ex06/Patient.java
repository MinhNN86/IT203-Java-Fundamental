package Session14.Ex06;

public class Patient {
    private String name;
    private int age;
    private String department;

    public Patient(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (Tuổi: " + age + ")";
    }
}
