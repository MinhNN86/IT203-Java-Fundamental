package Session06.Ex04;

public class Employee {
    private String id;
    private String name;
    private double salary;

    // Constructor không tham số
    public Employee() {
        this.id = "Unknown";
        this.name = "Unknown";
        this.salary = 0;
    }

    // Constructor có mã và tên
    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
        this.salary = 0;
    }

    // Constructor đầy đủ tham số
    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("=== THÔNG TIN NHÂN VIÊN ===");
        System.out.println("ID: " + this.id);
        System.out.println("Tên: " + this.name);
        System.out.println("Lương: $" + this.salary);
        System.out.println("========================");
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee("E001", "Nguyen Van A");
        Employee emp3 = new Employee("E002", "Tran Thi B", 1200.0);

        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();
    }
}
