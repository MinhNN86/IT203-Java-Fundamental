package Session09.Ex03_05;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        employees[0] = new OfficeEmployee("Alice", 5000, 1200);
        employees[1] = new ProductionEmployee("Bob", 300, 20);
        employees[2] = new OfficeEmployee("Charlie", 4500, 1000);
        employees[3] = new ProductionEmployee("David", 250, 25);

        double totalSalary = 0;
        for (Employee emp : employees) {
            emp.displayInfo();
            totalSalary += emp.calculateSalary();
            System.out.println("---");
        }
        System.out.println("Total salary: " + totalSalary);
    }
}
