package com.kevinrtai.euler.p21_30;

public class Sorts {

	public static void main(String[] args) {
		
		long startTime;
		long endTime;
		long duration;
		
		for(int i = 0; i < 1000000000; i++) {
			
		}
		
		startTime = System.nanoTime();
		bubbleSort();
		endTime = System.nanoTime();
		
	}
	
	public int[] bubbleSort(int[] nums) {
		boolean notSorted = true;
		int i = 0;
		while(notSorted) {
			if(i > nums.length - 1) {
				i = 0;
			}
		}
	}
}
