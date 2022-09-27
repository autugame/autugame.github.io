package com.KFC;

import java.util.List;

public class KFCmanagement_system {
	public String buy(String foodName, int money) throws KFCNoMoneyException {
		if (!"汉堡包".equals(foodName) && !"香辣鸡腿堡".equals(foodName)) {
			throw new KFCNoMoneyException("No This Food!");
		} else if (money < 50) {
			throw new KFCNoMoneyException("KFC Crazy Thursday Good Brother Vme 50RMB.");
		} 
		return "购买成功";
		
	}
}
