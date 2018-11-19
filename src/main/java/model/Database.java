package model;


import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String,User> users = new HashMap<>();

    public Database() {
        users.put("Dawit",new User("Dawit","qwer"));
        users.put("Bire",new User("Bire","asdf"));
        users.put("Ali",new User("Ali","zxcv"));
    }

    public User getUser(String username, String password) {
        User user = users.get(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    public void addUser(String username, String password) throws Exception {
        if(users.containsKey(username))
            throw new Exception("The username is already taken");
        users.put(username, new User(username, password));
    }
}
