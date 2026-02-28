package Session14;

import java.util.HashSet;
import java.util.Set;

public class Ex03 {
    public static void main(String[] args) {

        Set<String> thuocMoi = new HashSet<>();
        thuocMoi.add("Aspirin");
        thuocMoi.add("Caffeine");
        thuocMoi.add("Paracetamol");

        Set<String> diUng = new HashSet<>();
        diUng.add("Penicillin");
        diUng.add("Aspirin");

        // ===== Tìm giao (retainAll) =====
        Set<String> canhBao = new HashSet<>(thuocMoi); // tạo bản sao
        canhBao.retainAll(diUng);

        // ===== Tìm hiệu (removeAll) =====
        Set<String> thanhPhanAnToan = new HashSet<>(thuocMoi); // tạo bản sao
        thanhPhanAnToan.removeAll(diUng);

        System.out.println("Cảnh báo dị ứng: " + canhBao);
        System.out.println("Thành phần an toàn: " + thanhPhanAnToan);
    }
}
