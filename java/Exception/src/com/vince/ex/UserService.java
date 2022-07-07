package com.vince.ex;

public class UserService {
	public User login(String username, String password) throws MyException {
		if (!"admin".equals(username)) {
			throw new MyException("用户名错误");
		} else if (!"12345".equals(password)) {
			throw new MyException("密码错误");
		}
		User user = new User("admin", "12345", 18, "男");
		return user;
	}
}
