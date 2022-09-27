package com.autuo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String val1 = "801834213821083";
		String val2 = "8098324760708";
		BigInteger b1 = new BigInteger(val1);
		BigInteger b2 = new BigInteger(val2);
		System.out.println(b1.add(b2));
		System.out.println(b1.subtract(b2));
		System.out.println(b1.multiply(b2));
		System.out.println(b1.divide(b2));
		System.out.println(b1.remainder(b2));
		System.out.println(Arrays.toString(b1.divideAndRemainder(b2)));
		
		String val3 = "832.74890712089347";
		String val4 = "683.827013409872";
		BigDecimal b3 = new BigDecimal(val3);
		BigDecimal b4 = new BigDecimal(val4);
		System.out.println(b3.add(b4));
		System.out.println(b3.subtract(b4));
		System.out.println(b3.multiply(b4));
		//System.out.println(b3.divide(b4));
		System.out.println(b3.remainder(b4));
		System.out.println(Arrays.toString(b3.divideAndRemainder(b4)));
		
		System.out.println(b3.scale() - b4.scale());
		double pi = 3.1415927;
		System.out.println(new DecimalFormat("0").format(pi));
		long num = 68399;
		System.out.println(new DecimalFormat("###,###").format(num+));
	}

}
