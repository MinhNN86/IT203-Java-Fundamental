package Session15.Ex05;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyCaseQueue {
    private Queue<EmergencyCase> cases = new LinkedList<>();

    public void addCase(EmergencyCase c) {
        cases.offer(c);
        System.out.println("Đã tiếp nhận bệnh nhân: " + c.getPatient().getName());
    }

    public EmergencyCase getNextCase() {
        return cases.poll();
    }

    public boolean isEmpty() {
        return cases.isEmpty();
    }
}
