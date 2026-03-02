package Session15.Ex02;

import java.util.LinkedList;
import java.util.Queue;

public class PatientQueue {
    private Queue<Patient> queue = new LinkedList<>();

    // Thêm bệnh nhân vào hàng đợi
    public void addPatient(Patient patient){
        queue.offer(patient);
        System.out.println("Đã thêm bệnh nhân: " + patient.getName());
    }

    // Lấy bệnh nhân tiếp theo
    public Patient callNextPatient(){
        if(queue.isEmpty()){
            System.out.println("Không có bệnh nhân nào trong hàng đợi.");
            return null;
        }
        return queue.poll();
    }

    // Xem bệnh nhân tiếp theo
    public Patient peekNextPatient(){
        if(queue.isEmpty()){
            System.out.println("Không có bệnh nhân nào trong hàng đợi.");
            return null;
        }
        return queue.peek();
    }

    // Kiểm tra rỗng
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    // Hiển thị danh sách bệnh nhân đang chờ
    public void displayQueue(){
        if(queue.isEmpty()){
            System.out.println("Hàng đợi bệnh nhân trống.");
            return;
        }
        System.out.println("Danh sách bệnh nhân đang chờ:");
        for(Patient patient : queue){
            System.out.println(patient);
        }
    }
}
