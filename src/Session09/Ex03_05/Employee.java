package Session09.Ex03_05;

public abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}
