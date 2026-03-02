package Session15.Ex06;

import java.util.LinkedList;
import java.util.Queue;

public class PatientWaitingQueue {
    private Queue<Patient> waitingQueue = new LinkedList<>();
    private int totalPatients = 0;

    public void addPatient(Patient p) {
        waitingQueue.offer(p);
        totalPatients++;
    }

    public Patient callNextPatient() {
        if (!waitingQueue.isEmpty()) {
            totalPatients--;
            return waitingQueue.poll();
        }
        return null;
    }

    public int getTotalPatients() {
        return totalPatients;
    }
}