package com.vince.ex;

public class AssertDemo {
	public static void main(String[] args) {
		int result = add(10, 10);
		int a = 10;
		int b = 10;
		String isResult = (a == b ? "正确" : "不正确");
		System.out.println(isResult);
	}

	private static int add(int a, int b) {
		return a + b;
	}
}
