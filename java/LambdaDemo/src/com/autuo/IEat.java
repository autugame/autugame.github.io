package com.autuo;

public interface IEat {
	public abstract String eat(final String thing, final String name);
	public default void print() {
		System.out.println("text");
	}
	public static void method() {
		System.out.println("static method...");
	}
}
