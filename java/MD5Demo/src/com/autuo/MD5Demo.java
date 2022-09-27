package com.autuo;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class MD5Demo {
	private static String savePassword = "4QrcOUm6Wau+VuBX8g+IPg==";
	public static void main(String[] args) {
		
		text();
		System.out.println(login("123456"));
	}
	
	private static boolean login(String password) {
		if (savePassword.equals(md5(password))) {
			return  true;
		} else {
			return false;
		}

	}
	
	private static String md5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] bytes = md.digest(password.getBytes("UTF-8"));
			//System.out.println(Arrays.toString(bytes));
			String str = Base64.getEncoder().encodeToString(bytes);
			return str;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static void text() {
		String password = "123456";
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] bytes = md.digest(password.getBytes("UTF-8"));
			System.out.println(Arrays.toString(bytes));
			System.out.println(Base64.getEncoder().encodeToString(bytes));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
