package Session15.Ex03;

public class Main {
    public static void main(String[] args) {
        MedicationProcessChecker checker = new MedicationProcessChecker();

        String[] actions1 = {"PUSH", "PUSH", "POP", "POP"};
        String[] actions2 = {"PUSH", "POP", "POP"};
        String[] actions3 = {"PUSH", "PUSH", "POP"};

        System.out.println("Kiểm tra ca trực 1:");
        checker.checkProcess(actions1);
        checker.reset();

        System.out.println("\nKiểm tra ca trực 2:");
        checker.checkProcess(actions2);
        checker.reset();

        System.out.println("\nKiểm tra ca trực 3:");
        checker.checkProcess(actions3);
        checker.reset();
    }
}
