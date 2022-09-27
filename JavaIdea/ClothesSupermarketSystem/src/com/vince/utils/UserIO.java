package com.vince.utils;

import com.vince.bean.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserIO {
    public static List<User> users = new ArrayList<>();
    private static final String USER_FILE = "user.obj";
    public boolean writeUsers() throws BusinessException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USER_FILE));
            out.writeObject(users);
            out.close();
        } catch (IOException e) {
            throw new BusinessException("io.write.error");
        }

        return true;
    }

    public boolean readUsers() throws BusinessException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE));
            users = (List<User>) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new BusinessException("io.read.error");
        }
        return true;
    }

    public void add(User user) {
        user.setId(users.size() + 1);
        users.add(user);
    }

    public User findByUsernameAndPassword(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

}
