package com.autuo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.StringWriter;

public class StringStreamDemo {

	private static void stringReader() {
		String info = "good good study day day up";
		StringReader sr = new StringReader(info);
		StreamTokenizer st = new StreamTokenizer(sr);//流标记器
		
		int count = 0;
		while (st.ttype != StreamTokenizer.TT_EOF) {
			try {
				if (st.nextToken() == StreamTokenizer.TT_WORD) {
					count++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sr.close();
		System.out.println("一共有" + count + "个单词");
	}
	
	private static void stringWriter() {
		StringWriter sw = new StringWriter();
		String name = "小丹";
		sw.write(name);
		System.out.println(sw.getBuffer());
		System.out.println(sw.toString());
		try {
			sw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		//stringReader();
		//stringWriter();
	}

}
