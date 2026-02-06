package Session10.lyThuyet;

// Demo interface
public interface IColorable {
    // Hằng số: mặc định các biến được khai báo trong interface là "pubic static
    // final"
    String YELLOW = "Màu vàng";
    String RED = "Màu đỏ";

    // phương thức trừu tượng: không có phần thân, mặc định là "public abstract
    // method"
    void showColor(String color);

    String getColorHexCode(String color);
}
