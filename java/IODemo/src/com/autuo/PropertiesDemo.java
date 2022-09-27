package com.autuo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesDemo {

	public static String version = "";
	public static String username = "";
	public static String password = "";
	
	static {
		//readConfig();
	}
	
	private static void writeConfig(String version, String username, String password) {
		Properties p = new Properties();
		p.put("app.version", version);
		p.put("db.username", username);
		p.put("db.password", password);
		OutputStream out;
		try {
			out = new FileOutputStream("config.properties");
			p.store(out, "更新配置信息");
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void readConfig() {
		Properties p = new Properties();
		InputStream inStream;
		try {
			inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/res/config.properties");
			p.load(inStream);
			version = p.getProperty("app.version");
			username = p.getProperty("db.username");
			password = p.getProperty("db.password");
			
			inStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//writeConfig("2", "vince", "32415");
		readConfig();
		System.out.println(PropertiesDemo.version);
		System.out.println(PropertiesDemo.username);
		System.out.println(PropertiesDemo.password);

	}

}
