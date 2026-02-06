package Session10.Ex05;

public class Main {
    public static void main(String[] args) {

        Employee emp1 = new OfficeStaff("Nguyễn Văn A", 8000000);
        Employee emp2 = new Manager("Trần Thị B", 12000000, 5000000);

        printSalary(emp1);
        System.out.println("-------------------");
        printSalary(emp2);
    }

    public static void printSalary(Employee employee) {
        employee.displayInfo();
        System.out.println("Lương thực nhận: " + employee.calculateSalary());

        if (employee instanceof BonusCalculator) {
            System.out.println("Có thưởng KPI");
        } else {
            System.out.println("Không có thưởng KPI");
        }
    }
}
