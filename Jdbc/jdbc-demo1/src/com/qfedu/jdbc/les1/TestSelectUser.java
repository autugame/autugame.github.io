package com.qfedu.jdbc.les1;

import com.qfedu.jdbc.dao.UserDAO;
import com.qfedu.jdbc.dto.User;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestSelectUser {
    public static void main(String[] args) throws SQLException {
        for (User u : new UserDAO().listUser()) {
            System.out.println(u);
        }
    }


}
