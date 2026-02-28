package Session14;

import java.util.LinkedHashSet;
import java.util.Set;

public class Ex01 {
    public static void main(String[] args) {
        String[] input = {
                "Nguyễn Văn A – Yên Bái",
                "Trần Thị B – Thái Bình",
                "Nguyễn Văn A – Yên Bái",
                "Lê Văn C – Hưng Yên"
        };
        Set<String> danhSach = new LinkedHashSet<>();

        for (String benhNhan : input) {
            danhSach.add(benhNhan);
        }

        System.out.println("Danh sách gọi khám");
        for (String benhNhan : danhSach) {
            System.out.println(benhNhan);
        }

    }
}
