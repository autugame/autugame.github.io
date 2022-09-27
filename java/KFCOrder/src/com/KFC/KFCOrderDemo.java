package com.KFC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KFCOrderDemo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("欢迎来到KFC管理系统");
		System.out.println("汉堡包");
		System.out.println("香辣鸡腿堡");
		System.out.println("请输入要购买的食物");
		
		String food = input.nextLine();

		KFCmanagement_system kfc = new KFCmanagement_system();
		String message;
		try {
			message = kfc.buy(food, 30);
			System.out.println(message);
		} catch (KFCNoMoneyException e) {
			e.printStackTrace();
		}
	}

}
