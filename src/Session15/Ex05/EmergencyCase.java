package Session15.Ex05;

import java.util.Stack;

public class EmergencyCase {
    private Patient patient;
    private Stack<TreatmentStep> steps = new Stack<>();

    public EmergencyCase(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    // Thêm bước xử lý
    public void addStep(TreatmentStep step) {
        steps.push(step);
        System.out.println("Đã thêm bước: " + step);
    }

    // Undo bước gần nhất
    public TreatmentStep undoStep() {
        if (!steps.isEmpty()) {
            TreatmentStep removed = steps.pop();
            System.out.println("Đã hoàn tác: " + removed);
            return removed;
        }
        System.out.println("Không có bước nào để undo.");
        return null;
    }

    // Hiển thị các bước
    public void displaySteps() {
        System.out.println("Các bước xử lý của bệnh nhân " + patient.getName() + ":");
        for (TreatmentStep step : steps) {
            System.out.println(step);
        }
    }

}
