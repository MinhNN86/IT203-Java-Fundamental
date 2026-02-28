package Session14.Ex05;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Comparator<Patient> triageComparator = (p1, p2) -> {
            if(p1.getSeverity() != p2.getSeverity()){
                return p1.getSeverity() - p2.getSeverity(); // Ưu tiên theo severity
            } else {
                return p1.getArrivalTime() - p2.getArrivalTime(); // Nếu severity bằng nhau, ưu tiên đến trước
            }
        };

        Set<Patient> queue = new TreeSet<>(triageComparator);

        queue.add(new Patient("Bệnh nhân A", 3, 800));
        queue.add(new Patient("Bệnh nhân B", 1, 815));
        queue.add(new Patient("Bệnh nhân C", 1, 805));
        queue.add(new Patient("Bệnh nhân D", 2, 810));

        System.out.println("Thứ tự xủ lý cấp cứu: ");
        for(Patient p : queue){
            System.out.println(p);
        }
    }

}
