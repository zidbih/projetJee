package projet_jee;

import java.util.HashMap;
import java.util.Map;


public class UserService {
    private static final Map<String, User> userStore = new HashMap<>();

    static {
        // Add the default user
        userStore.put("admin", new User("admin", "12345"));
    }

    public static User getUser(String username) {
    	
        return userStore.get(username);

    }
    
}

