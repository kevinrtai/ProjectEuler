package com.kevinrtai.euler.p11_20;

import java.math.BigInteger;

public class Problem20 {

	//Find the sum of the digits of 100!
	public static void main(String[] args) {
		BigInteger facto = factorial(new BigInteger("100"));
		
		String digits = facto.toString();
		BigInteger result = new BigInteger("0");
		for(int i = 0; i < digits.length(); i++) {
			result = result.add(new BigInteger(digits.charAt(i) + ""));
			System.out.println(result);
		}
		
		System.out.println(result);
	}
	
	//Recursively find the factorial of a number.
	public static BigInteger factorial(BigInteger num) {
		if(num.equals(new BigInteger("1"))) {
			return new BigInteger("1");
		}
		else {
			return num.multiply(factorial(
					num.subtract(new BigInteger("1"))));
		}
	}
}
