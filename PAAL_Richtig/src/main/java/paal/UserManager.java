package paal;

public class UserManager {

    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserManager.user = user;
    }
}