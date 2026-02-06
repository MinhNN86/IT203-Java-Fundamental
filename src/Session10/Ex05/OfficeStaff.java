package Session10.Ex05;

public class OfficeStaff extends Employee{

    public OfficeStaff(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return 0;
    }
}
