package Session07.Ex06;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(1, "alice", "password123");
        User u2 = new User(2, "bob", "secure456");

        UserManager.addUser(u1);
        UserManager.addUser(u2);

        UserManager.showAllUsers();

        User found = UserManager.findById(1);
        System.out.println("Tìm thấy: " + found);
    }
}
