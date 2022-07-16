package com.autuo;

public class Test {

	public static void main(String[] args) {
		Cat cat = new Cat("百越黑鱼", 100);
		try {
			Cat newCat = (Cat) cat.clone();
			
			System.out.println(cat);
			System.out.println(newCat);
			//System.out.println(cat.toString());
			//System.out.println(newCat.toString());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
