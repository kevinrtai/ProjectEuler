package com.kevinrtai.euler.p21_30;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Problem22 {

	//We're going ahead to try and implement mergesort. I'm going to have
	//to learn it properly at some point anyway lol.
	public static <T> void main(String[] args) {
		Scanner reader = null;
		try {
			reader = new Scanner(new File("./input/22/names.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] names;
		names = reader.nextLine().split(",");
		reader.close();
		
		ArrayList<String> cheating = new ArrayList<String>();
		for(String s:names) {
			cheating.add(s);
		}
		
		//Just kidding. Let's use ArrayList.sort();
		cheating.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		
		BigInteger sum = new BigInteger("0");
		for(int i = 0; i < cheating.size(); i++) {
			BigInteger nameVal = new BigInteger(evaluateNameValue(cheating.get(i)) + "");
			BigInteger result = nameVal.multiply(new BigInteger((i + 1) + ""));
			sum = sum.add(result);
//			if(i == 937) {
//				System.out.println(cheating.get(i));
//				System.out.println(nameVal);
//				System.out.println(result);
//				System.out.println(sum);
//			}
		}
		
		System.out.println(sum);
	}

	public static int evaluateNameValue(String name) {
		char[] chars = name.toCharArray();
		
		//Use the ASCII table to evaluate. All of the names are
		//in uppercase, so we can just subtract from the 
		//char value.
		int[] values = new int[chars.length];
		for(int i = 0; i < chars.length; i++) {
			values[i] = (int)chars[i] - 64;
		}
		
		int sum = 0;
		for(int i:values) {
			sum += i;
		}
		return sum;
	}
}
