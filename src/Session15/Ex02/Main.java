package Session15.Ex02;

public class Main {
    public static void main(String[] args) {
        PatientQueue patientQueue = new PatientQueue();

        patientQueue.addPatient(new Patient("BN01", "Nguyen Van A", 30));
        patientQueue.addPatient(new Patient("BN02", "Tran Thi B", 25));
        patientQueue.addPatient(new Patient("BN03", "Le Van C", 40));

        patientQueue.displayQueue();

        System.out.println("\nBệnh nhân tiếp theo:");
        System.out.println(patientQueue.peekNextPatient());

        System.out.println("\nGọi bệnh nhân tiếp theo:");
        System.out.println(patientQueue.callNextPatient());

        System.out.println("\nDanh sách còn lại: ");
        patientQueue.displayQueue();
    }
}
