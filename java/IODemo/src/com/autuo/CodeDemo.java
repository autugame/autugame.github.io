package com.autuo;

import java.io.UnsupportedEncodingException;

public class CodeDemo {

	public static void main(String[] args) {
		String info = "晚上到老王家";
		try {
			String newInfo = new String(info.getBytes("utf-8"), "iso8859-1");
			System.out.println(newInfo);
			
			String newInfo2 = new String(newInfo.getBytes("iso8859-1"), "utf-8");
			System.out.println(newInfo2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
