package Session09.Ex03_05;

public class Manager extends Employee {
    private double salary;
    private String room;

    public Manager(String name, double salary, String room) {
        super(name);
        this.salary = salary;
        this.room = room;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Room: " + room);
    }
}
