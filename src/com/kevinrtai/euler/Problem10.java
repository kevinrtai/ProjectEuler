package com.kevinrtai.euler;

public class Problem10 {

	//Finds sum of all primes below 2 million.
	public static void main(String[] args) {
		long sum = 2;
		for(int i = 3; i < 2000000; i+=2) {	
			if(isPrime(i)) {
				sum+=i;
				System.out.println(i);
			}
		}
		System.out.println("Sum: " + sum);
	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}