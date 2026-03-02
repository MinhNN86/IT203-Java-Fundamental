package Session15.Ex05;

public class Main {
    public static void main(String[] args) {

        EmergencyCaseQueue queue = new EmergencyCaseQueue();

        // Tạo bệnh nhân
        EmergencyCase case1 = new EmergencyCase(new Patient("BN01", "Nguyen Van A"));
        EmergencyCase case2 = new EmergencyCase(new Patient("BN02", "Tran Thi B"));

        // Thêm vào hàng chờ
        queue.addCase(case1);
        queue.addCase(case2);

        // Xử lý bệnh nhân đầu tiên
        EmergencyCase current = queue.getNextCase();

        current.addStep(new TreatmentStep("Tiếp nhận bệnh nhân", "08:00"));
        current.addStep(new TreatmentStep("Chẩn đoán ban đầu", "08:05"));
        current.addStep(new TreatmentStep("Tiêm thuốc", "08:10"));

        current.displaySteps();

        // Undo bước gần nhất
        current.undoStep();

        System.out.println("\nSau khi undo:");
        current.displaySteps();
    }
}
