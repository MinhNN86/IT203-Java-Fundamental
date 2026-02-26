package Session13.Ex04;

import java.util.LinkedList;

public class EmergencyRoom {
    private LinkedList<String> waitingList = new LinkedList<>();

    // Bệnh nhân thường
    public void patientCheckIn(String name){
        waitingList.addLast(name);
        System.out.println(name + " đã vào hàng đợi.");
    }

    // Bệnh nhân cấp cứu
    public void emergencyCheckIn(String name){
        waitingList.addFirst(name);
        System.out.println(name + " ( Cấp cứu ) được ưu tiên lên đầu hàng");
    }

    public void treatPatient(){
        if(waitingList.isEmpty()){
            System.out.println("Không còn bệnh nhân");
            return;
        }

        String patient = waitingList.removeFirst();
        System.out.println("Đang điều trị cho bệnh nhân: " + patient);
    }
}
