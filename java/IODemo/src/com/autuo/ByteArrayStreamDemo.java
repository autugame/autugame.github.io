package com.autuo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {
	
	private static void byteArray() {
		String s = "1432764123fejkerjj(2743723284&%^%$$#$$%^&&";
		ByteArrayInputStream bais = new ByteArrayInputStream(s.getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int curr = -1;
		while ((curr = bais.read()) != -1) {
			if ((curr >= 65 && curr <= 90) || (curr >= 97 && curr <= 122)) {
				baos.write(curr);
			}
		}
		System.out.println(baos.toString());
	}
	
	public static void main(String[] args) {
		byteArray();
	}
	
}
