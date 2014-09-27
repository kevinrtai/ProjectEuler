package com.kevinrtai.euler.p1_10;

import java.util.ArrayList;

public class Problem09 {
	//Attempts to find the special Pythagorean Triplet whose sum equals 1000.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean notFound = true;
		double a = 0;
		double b = 0;
		double c = 0;
		ArrayList<Integer> bPossible = new ArrayList<>();
		while(notFound) {
			a += 1;
			bPossible.clear();
			System.out.println("a = " + a);
			for(int i = (int)a+1; i < 1000; i++) {
				bPossible.add(i);
			}
			for(int i:bPossible) {
				b = i;
				c = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
				if(a+b+c == 1000) {
					System.out.println("a = " + a + "\nb = " + b + "\nc = " + c);
					System.out.println(a*b*c);
					notFound = false;
				}
			}
		}
	}

}
