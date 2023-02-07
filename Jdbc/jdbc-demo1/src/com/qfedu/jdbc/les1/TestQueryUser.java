package com.qfedu.jdbc.les1;

import com.qfedu.jdbc.dao.UserDAO;
import com.qfedu.jdbc.dto.User;
import com.qfedu.jdbc.utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestQueryUser {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int id = 7;
        System.out.println(new UserDAO().queryUser(id));
    }

}
