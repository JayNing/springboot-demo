package com.ning.springbootdemo.cache;

import com.ning.springbootdemo.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserCache {

    private Map<String, User> userMap = new HashMap<>();

    public void addUser(String username, User user){
        userMap.put(username,user);
    }

    public User getUser(String username){
        return userMap.get(username);
    }

}