package Session15.Ex04;

public class Main {
    public static void main(String[] args) {
        EmergencyQueue queue = new EmergencyQueue();

        queue.addPatient(new EmergencyPatient("BN01", "Nguyen Van A", 2));
        queue.addPatient(new EmergencyPatient("BN02", "Tran Thi B", 1));
        queue.addPatient(new EmergencyPatient("BN03", "Le Van C", 2));
        queue.addPatient(new EmergencyPatient("BN04", "Pham Van D", 1));

        queue.displayQueue();

        System.out.println("\nGọi khám:");
        System.out.println(queue.callNextPatient());
        System.out.println(queue.callNextPatient());

        System.out.println("\nDanh sách còn lại:");
        queue.displayQueue();
    }
}
