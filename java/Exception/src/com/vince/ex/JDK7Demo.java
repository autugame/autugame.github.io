package com.vince.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JDK7Demo {

	public static void main(String[] args) {
		// Scanner input = new Scanner(System.in);

		// br.close();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("请输入数字");
			String info = br.readLine();
			System.out.println(info);
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
