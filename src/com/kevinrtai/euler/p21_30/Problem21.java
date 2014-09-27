package com.kevinrtai.euler.p21_30;

import java.util.ArrayList;

public class Problem21 {

	//Sum of all amicable numbers below 10000 where amicable
	//numbers are numbers whose factors sum to one another.
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 1; i < 10000; i++) {
			numbers.add(i);
		}
		
		int a, b;
		int sum = 0;
		
		while(numbers.size() != 0) {
			a = numbers.get(0);
			System.out.println(a);
			b = sumArray(factors(a));
			System.out.println(b);
			if(b != a && sumArray(factors(b)) == a) {
				System.out.println(a + " & " + b);
				sum += a;
				sum += b;
				numbers.remove(0);
				//Have to do this because of autoboxing/unboxing.
				for(int i = 0; i < numbers.size(); i++) {
					if(numbers.get(i) == b) {
						numbers.remove(i);
					}
				}
			}
			else {
				numbers.remove(0);
			}
			System.out.println();
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
