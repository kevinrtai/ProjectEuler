package com.kevinrtai.euler.p21_30;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem22 {

	//We're going ahead to try and implement mergesort. I'm going to have
	//to learn it properly at some point anyway lol.
	public static void main(String[] args) {
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
