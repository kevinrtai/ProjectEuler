package com.kevinrtai.euler.p11_20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem18 {
	
	private static ArrayList<long[]> pyramid;
	
	public static void main(String[] args) {
		//Read in the pyramid. Pretty big.
		Scanner reader = null;
		try {
			reader = new Scanner(new File("./input/67/triangle.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		//Read in the pyramid.
		pyramid = new ArrayList<long[]>();
		String[] line;
		long[] lineOfInts;
		while(reader.hasNext()) {
			line = reader.nextLine().split(" ");
			lineOfInts = new long[line.length];
			for(int i = 0; i < line.length; i++) {
				lineOfInts[i] = Integer.parseInt(line[i]);
			}
			pyramid.add(lineOfInts);
		}
		reader.close();
		
		//Reduce the bottom row each time.
		while(pyramid.size() > 1) {
			reduceBottomRow();
		}
		System.out.println(pyramid.get(0)[0]);
	}
	
	private static void reduceBottomRow() {
		long[] rowLast;
		long[] rowPenultimate;
		rowLast = pyramid.get(pyramid.size() - 1);
		rowPenultimate = pyramid.get(pyramid.size() - 2);
		long optA, optB;
		for(int i = 0; i < rowPenultimate.length; i++) {
			optA = rowLast[i] + rowPenultimate[i];
			optB = rowLast[i + 1] + rowPenultimate[i];
			rowPenultimate[i] = optA > optB ? optA:optB;
		}
		for(long i:rowPenultimate) {
			System.out.print(i + " ");
		}
		System.out.println();
		pyramid.set(pyramid.size() - 2, rowPenultimate);
		pyramid.remove(pyramid.size() - 1);
	}
}
