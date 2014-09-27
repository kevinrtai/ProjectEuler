package com.kevinrtai.euler;

public class Problem12 {

	//Finds the first triangle number to have over 500 divisors
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean notFound = true;
		int i = 1;
		while(notFound) {
			if(numberOfFactors(triangleNumber(i)) > 500) {
				System.out.println(triangleNumber(i));
				notFound = false;
			}
			i++;
		}
	}

	public static long triangleNumber(long num) {
		int sum = 0;
		for (long i = num; i>0; i--) {
			sum+=i;
		}
		System.out.print(sum);
		return sum;
	}
	
	public static long numberOfFactors(long num) {
		long numOfFactors = 0;
		for(long i = 1; i <= num; i++) {
			if(num % i == 0) {
				numOfFactors++;
//				System.out.print(" " + i);
			}
		}
		System.out.println(" " + numOfFactors);
		return numOfFactors;
	}
}
