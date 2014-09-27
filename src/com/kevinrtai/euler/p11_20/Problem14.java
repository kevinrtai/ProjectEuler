package com.kevinrtai.euler.p11_20;

import java.math.BigInteger;

public class Problem14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int biggestChainNumber = 0;
		int biggestChain = 0;
		BigInteger chain = new BigInteger("0");
		boolean not1 = true;
		int chainLength = 0;
		
		for(int i = 1000000; i > 1; i--) {
			chain = new BigInteger(Integer.toString(i));
			chainLength = 0;
			while(not1) {
				chain = collatz(chain);
				//System.out.println(chain);
				chainLength++;
				if(chain.toString().equals("1")) {
					not1 = false;
				}
			}
			System.out.println("Starting Number: " + i);
			System.out.println("\tChain Length: " + chainLength);
			if(chainLength > biggestChain) {
				biggestChain = chainLength;
				biggestChainNumber = i;
			}
			not1 = true;
		}
		System.out.println(biggestChainNumber);
	}

	public static BigInteger collatz(BigInteger num) {
		if(num.divideAndRemainder(new BigInteger("2"))[1].toString().equals("0")) {
			return num.divide(new BigInteger("2"));
		}
		else {
			return num.multiply(new BigInteger("3")).add(new BigInteger("1"));
		}
	}
}
