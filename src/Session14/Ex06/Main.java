package Session14.Ex06;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
                new Patient("Lan", 25, "Tim mạch"),
                new Patient("Hùng", 40, "Nội tiết"),
                new Patient("Mai", 30, "Tim mạch"),
                new Patient("Tuấn", 50, "Nội tiết"),
                new Patient("An", 60, "Tim mạch")
        );

        // Map gom nhóm theo khoa
        Map<String, List<Patient>> departmentMap = new HashMap<>();

        // Gom nhóm
        for (Patient p : patients) {
            departmentMap
                    .computeIfAbsent(p.getDepartment(), k -> new ArrayList<>())
                    .add(p);
        }

        // In cấu trúc Map
        System.out.println("DANH SÁCH BỆNH NHÂN THEO KHOA:");
        for (Map.Entry<String, List<Patient>> entry : departmentMap.entrySet()) {
            System.out.println("Khoa: " + entry.getKey());
            for (Patient p : entry.getValue()) {
                System.out.println("   - " + p);
            }
        }

        // Hiển thị bệnh nhân của một khoa bất kỳ
        String searchDepartment = "Tim mạch";
        System.out.println("\nBỆNH NHÂN KHOA " + searchDepartment + ":");
        List<Patient> list = departmentMap.get(searchDepartment);
        if (list != null) {
            list.forEach(System.out::println);
        }

        // Tìm khoa đông bệnh nhân nhất
        String maxDepartment = null;
        int maxSize = 0;

        for (Map.Entry<String, List<Patient>> entry : departmentMap.entrySet()) {
            if (entry.getValue().size() > maxSize) {
                maxSize = entry.getValue().size();
                maxDepartment = entry.getKey();
            }
        }

        System.out.println("\nKhoa " + maxDepartment + " đang đông nhất (" + maxSize + " bệnh nhân)");
    }
}
