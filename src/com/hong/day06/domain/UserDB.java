package com.hong.day06.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/19.
 */
public class UserDB {

    private static List<User> users = new ArrayList<User>();

    static {
        users.add(new User("hong", "123"));
        users.add(new User("weili", "321"));
    }

    public static List<User> findAllUsers() {
        return users;
    }

    public static boolean findUserByNameAndPassword(String username, String password) {
        for (User user : users) {
            if ((user.getName().equals(username)) && (user.getPassword().equals(password))) {
                return true;
            }
        }
        return false;
    }

}
