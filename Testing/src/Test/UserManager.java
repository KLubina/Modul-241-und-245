package Test;

import java.util.*;

public class UserManager {
    private Map<String, User> users = new HashMap<>();

    public UserManager() {
        loadUsers();
    }

    public void registerUser(String name) {
        if (!users.containsKey(name)) {
            users.put(name, new User(name));
            saveUsers();
        }
    }

    public User getUserByName(String name) {
        return users.get(name);
    }

    private void saveUsers() {
        DataStorageManager.saveObjectToFile(users, "users.dat");
    }

    @SuppressWarnings("unchecked")
    private void loadUsers() {
        Object data = DataStorageManager.loadObjectFromFile("users.dat");
        if (data instanceof Map) {
            users = (Map<String, User>) data;
        }
    }
}