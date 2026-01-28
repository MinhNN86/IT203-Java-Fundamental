package Session04;

public class Ex02 {
    public static void main(String[] args) {
        String moTa = "Cuốn sách Java cơ bản dành cho người mới bắt đầu, Kệ: A3-12, được nhiều sinh viên yêu thích.";

        if (moTa.contains("Kệ:")) {
            int startIndex = moTa.indexOf("Kệ:") + "Kệ:".length();
            int commaIndex = moTa.indexOf(",", startIndex);

            String viTri;

            if (commaIndex != -1) {
                viTri = moTa.substring(startIndex, commaIndex).trim();
            } else {
                viTri = moTa.substring(startIndex).trim();
            }

            String moTaMoi = moTa.replace("Kệ:", "Vị trí lưu trữ: ");
            // In kết quả
            System.out.println("Mã vị trí kệ sách: " + viTri);
            System.out.println("Mô tả sau khi cập nhật:");
            System.out.println(moTaMoi);
        } else {
            System.out.println("Không tìm thấy thông tin kệ sách trong mô tả.");
        }
    }
}
