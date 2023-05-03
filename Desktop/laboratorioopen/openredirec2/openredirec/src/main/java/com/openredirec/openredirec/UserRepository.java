package com.openredirec.openredirec;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private Map<String, User> users = new HashMap<>();
    
    public UserRepository() {
        users.put("admin", new User("admin", "admin"));
    }
    
    public User findByUsername(String username) {
        return users.get(username);
    }
}

    

