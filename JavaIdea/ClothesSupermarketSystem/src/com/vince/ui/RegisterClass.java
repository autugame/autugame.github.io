package com.vince.ui;

import com.vince.bean.User;
import com.vince.service.UserService;
import com.vince.service.impl.UserServiceImpl;
import com.vince.utils.BusinessException;

public class RegisterClass extends BaseClass {
    private UserService userService;
    public RegisterClass() {
        userService = ((UserService) beanFactory.getBean("userService"));
    }
    public void register() throws BusinessException {
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
        User user = new User(username, password);
        //UserService userService = new UserServiceImpl();
        userService.register(user);
    }
}
