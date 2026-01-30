package Session06.lyThuyet;

/**
 * KHÁI NIỆM LỚP TRONG JAVA:
 * - Lớp (Class) là khuôn mẫu để tạo ra các đối tượng
 * - Lớp định nghĩa thuộc tính và phương thức cho đối tượng
 * - Từ khóa "class" được sử dụng để khai báo một lớp
 * - Tên lớp nên viết hoa chữ cái đầu (PascalCase)
 */
public class Circle {

    // =================================================================================
    // THUỘC TÍNH (ATTRIBUTES/FIELDS):
    // - Thuộc tính là các biến được khai báo bên trong lớp
    // - Mô tả trạng thái hoặc đặc điểm của đối tượng
    // - Access modifier: private (chỉ truy cập trong lớp), public (truy cập từ bất
    // kỳ đâu)
    // - Nên sử dụng "private" để đảm bảo tính đóng gói (Encapsulation)
    // =================================================================================
    private double radius; // Thuộc tính private - chỉ truy cập trong class Circle

    // =================================================================================
    // CONSTRUCTOR (HÀM TẠO):
    // - Constructor là phương thức đặc biệt để khởi tạo đối tượng
    // - Có tên giống với tên lớp, không có kiểu trả về
    // - Được gọi tự động khi tạo đối tượng với từ khóa "new"
    // =================================================================================
    public Circle(double radius) {
        // =============================================================================
        // TỪ KHÓA "this":
        // - "this" tham chiếu đến đối tượng hiện tại
        // - Được sử dụng để phân biệt giữa thuộc tính và tham số cùng tên
        // - this.radius: tham chiếu đến thuộc tính radius của đối tượng
        // - radius (không có this): tham chiếu đến tham số của constructor
        // =============================================================================
        this.radius = radius; // Gán giá trị tham số cho thuộc tính của đối tượng
    }

    // =================================================================================
    // PHƯƠNG THỨC (METHODS):
    // - Phương thức định nghĩa hành vi/chức năng của đối tượng
    // - Có thể truy cập và thao tác với thuộc tính của lớp
    // - Access modifier: public (có thể gọi từ bên ngoài)
    // =================================================================================

    // Phương thức tính diện tích hình tròn
    public double getArea() {
        // Truy cập trực tiếp thuộc tính radius (không cần this vì không có xung đột
        // tên)
        return Math.PI * radius * radius; // π × r²
    }

    // Phương thức tính chu vi hình tròn
    public double getCircumference() {
        return 2 * Math.PI * radius; // 2 × π × r
    }

    // Phương thức getter để truy cập thuộc tính private từ bên ngoài
    public double getRadius() {
        return this.radius; // Sử dụng this để rõ ràng (tùy chọn khi không có xung đột)
    }

    // Phương thức setter để thay đổi giá trị thuộc tính private
    public void setRadius(double radius) {
        // Sử dụng this bắt buộc để phân biệt tham số và thuộc tính cùng tên
        this.radius = radius;
    }

    // =================================================================================
    // PHƯƠNG THỨC MAIN - ĐIỂM BẮT ĐẦU CHƯƠNG TRÌNH:
    // - static: thuộc về lớp, không cần tạo đối tượng để gọi
    // - void: không trả về giá trị
    // =================================================================================
    public static void main(String[] args) {
        // Tạo đối tượng từ lớp Circle - gọi constructor
        Circle circle1 = new Circle(5.0);

        // Sử dụng các phương thức của đối tượng
        System.out.println("Bán kính: " + circle1.getRadius());
        System.out.println("Diện tích: " + circle1.getArea());
        System.out.println("Chu vi: " + circle1.getCircumference());

        // Thay đổi thuộc tính thông qua setter
        circle1.setRadius(10.0);
        System.out.println("Sau khi thay đổi bán kính thành 10:");
        System.out.println("Diện tích mới: " + circle1.getArea());
        System.out.println("Chu vi mới: " + circle1.getCircumference());
    }
}
