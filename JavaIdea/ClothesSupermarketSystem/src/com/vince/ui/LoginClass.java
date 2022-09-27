package com.vince.ui;

import com.vince.bean.User;
import com.vince.service.UserService;
import com.vince.service.impl.UserServiceImpl;
import com.vince.utils.BusinessException;

public class LoginClass extends BaseClass {
    private UserService userService;

    public LoginClass() {
        userService = ((UserService) beanFactory.getBean("userService"));
    }
    public void login() throws BusinessException {
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
        //UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);
        if (user != null) {
            currUser = user;
        } else {
            throw new BusinessException("login.error");
        }
    }
}
