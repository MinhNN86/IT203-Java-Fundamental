package Session06.Ex06;

public class User {
    private String id;
    private String username;
    private String email;
    private String password;

    public User(String id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        setEmail(email);
        setPassword(password);
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        if (password != null && !password.trim().isEmpty()) {
            this.password = password;
            System.out.println("Cập nhật mật khẩu thành công.");
        } else {
            System.out.println("Password không được rỗng");
        }
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
            System.out.println("Cập nhật email thành công.");
        } else {
            System.out.println("Email không hợp lệ.");
        }
    }

    public void displayInfo() {
        System.out.println("=== THÔNG TIN NGƯỜI DÙNG ===");
        System.out.println("ID: " + this.id);
        System.out.println("Username: " + this.username);
        System.out.println("Email: " + this.email);
        System.out.println("========================");
    }

    public static void main(String[] args) {
        User user1 = new User("1", "minhnguyen", "123456", "minh@gmail.com");

        User user2 = new User("2", "admin", "admin123", "admingmail.com");

        User user3 = new User("3", "guest", "", "guest@gmail.com");

        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();
    }

}
