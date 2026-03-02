package Session15.Ex04;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyQueue {

    private Queue<EmergencyPatient> emergencyQueue = new LinkedList<>();
    private Queue<EmergencyPatient> normalQueue = new LinkedList<>();

    // Thêm bệnh nhân
    public void addPatient(EmergencyPatient p) {
        if (p.getPriority() == 1) {
            emergencyQueue.offer(p);
        } else {
            normalQueue.offer(p);
        }
        System.out.println("Đã thêm bệnh nhân: " + p.getName());
    }

    // Gọi bệnh nhân tiếp theo
    public EmergencyPatient callNextPatient() {
        if (!emergencyQueue.isEmpty()) {
            return emergencyQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            return normalQueue.poll();
        } else {
            System.out.println("Không có bệnh nhân.");
            return null;
        }
    }

    // Hiển thị danh sách chờ
    public void displayQueue() {
        System.out.println("\n--- Danh sách chờ ---");

        System.out.println("Cấp cứu:");
        for (EmergencyPatient p : emergencyQueue) {
            System.out.println(p);
        }

        System.out.println("Thông thường:");
        for (EmergencyPatient p : normalQueue) {
            System.out.println(p);
        }
    }
}