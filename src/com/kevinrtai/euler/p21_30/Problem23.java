package com.kevinrtai.euler.p21_30;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem23 {

	//Find the sum of all numbers that can't be written as the
	//sum of two abundant numbers.
	public static void main(String[] args) {
		ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
		for(int i = 1; i < 28124; i++) {
			if(sumArray(factors(i)) > i) {
				abundantNumbers.add(i);
			}
		}
		System.out.println("Found all abundant numbers.");
		
		ArrayList<Integer> sumsOfAbundantNumbers = new ArrayList<Integer>();
		for(int i = 0; i < abundantNumbers.size(); i++) {
			for(int j = i; j < abundantNumbers.size(); j++) {
				sumsOfAbundantNumbers.add(abundantNumbers.get(i) + 
						abundantNumbers.get(j));
			}
		}
		System.out.println("Found all sums of abundant numbers.");
		
		BigInteger sum = new BigInteger("0");
		
		System.out.println(sumsOfAbundantNumbers.size());
		
		outerLoop:
		for(int i = 0; i < 28124; i++) {
			System.out.println(i);
			for(int j = 0; j < sumsOfAbundantNumbers.size(); j++) {
				if(sumsOfAbundantNumbers.get(j) == i) {
					continue outerLoop;
				}
			}
			sum = sum.add(new BigInteger("" + i));
		}
		
		System.out.println(sum);
	}

	//For the purposes of this problem, we don't include the number
	//itself as a factor (even though we include 1 for some reason).
	public static ArrayList<Integer> factors(int num) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for(int i = 1; i <= Math.sqrt((double)num); i++) {
			if(num % i == 0) {
				factors.add(i);
			}
		}
		int size = factors.size();
		for(int i = 0; i < size; i++) {
			if(num / factors.get(i) != factors.get(i) &&
					num / factors.get(i) != num) {
				factors.add(num / factors.get(i));
			}
		}

		return factors;
	}

	public static int sumArray(ArrayList<Integer> arr) {
		int sum = 0;
		for(int i:arr) {
			sum += i;
		}
		return sum;
	}
	
}
