package com.qfedu.bookmall_ms.service;

import com.qfedu.bookmall_ms.dao.UserDAO;
import com.qfedu.bookmall_ms.dto.User;

public class UserService {
    //管理员登录业务通过返回User否则null
    public User checkLogin(String userName, String userPwd){
        //根据userName查询管理员信息
        UserDAO userDAO = new UserDAO();
        User user = userDAO.selectUserByUserName(userName);
        //判断密码
        if (user != null && user.getUserPwd().equals(userPwd)){
            return user;
        } else {
            return null;
        }
    }
}
