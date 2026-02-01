package Session07.Ex06;

import Session07.Ex06.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static List<User> users = new ArrayList<>();

    public static void addUser(User user) {
        users.add(user);
    }

    public static User findById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public static void showAllUsers() {
        for (User u : users) {
            System.out.println(u);
        }
    }
}
