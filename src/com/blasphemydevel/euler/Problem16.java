package com.blasphemydevel.euler;

import java.math.BigInteger;

public class Problem16 {

	//Finds the sum of the digits of the number 2^1000
	public static void main(String[] args) {
		BigInteger number = new BigInteger("1");
		for(int i = 1; i <= 1000; i++) {
			number = number.multiply(new BigInteger("2"));
		}
		String s = number.toString();
		char[] digits = s.toCharArray();
		BigInteger digitSum = new BigInteger("0");
		for(char i:digits) {
			digitSum = digitSum.add(new BigInteger(Character.toString(i)));
		}
		System.out.println(digitSum.toString());
	}
}
