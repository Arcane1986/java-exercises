package com.rich.cheesemvc.models.User;

import java.util.HashMap;
import com.rich.cheesemvc.User.User;

public class UserData {
    private static HashMap<Integer,User> users = new HashMap<>();
    private static int nextid = 1;

    public static void addUser(User user){
        users.put(nextid,user);
        user.setId(nextid);
        nextid++;
    }

    public static HashMap<Integer, User> getUsers() {
        return users;
    }

    public static User getUser(int id){
        return users.get(id);
    }
}
