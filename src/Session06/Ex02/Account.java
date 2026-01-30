package Session06.Ex02;

public class Account {
    private String username;
    private String password;
    private String email;

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void displayInfo() {
        System.out.println("Username: " + this.username);
        System.out.println("Email: " + this.email);
    }

    public static void main(String[] args) {
        Account account = new Account("user123", "pass123", "user123@example.com");
        account.displayInfo();
        account.changePassword("newpass456");
        System.out.println("Password changed successfully.");
    }
}
