package com.KFC;

public class KFCNoMoneyException extends Exception {
	public KFCNoMoneyException() {
		super();
	}
	public KFCNoMoneyException(String message) {
		super(message);
	}
}
