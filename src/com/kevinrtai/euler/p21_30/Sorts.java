package com.kevinrtai.euler.p21_30;

import java.util.Random;

public class Sorts {
	
	private static int[] numbers;
	private static int[] helper;
	
	public static void main(String[] args) {
		int size = 1000000;
		long startTime;
		long endTime;
		long duration;
		Random random = new Random();
		int[] sortable = new int[size];
		int[] result;
		
		for(int i = 0; i < size; i++) {
			sortable[i] = random.nextInt();
		}
		System.out.println("Made array");
		
		//MERGESORT
		numbers = new int[sortable.length];
		for(int i = 0; i < sortable.length; i++) {
			numbers[i] = sortable[i];
		}
		helper = new int[numbers.length];
		
		startTime = System.nanoTime();
		mergeSort(0, numbers.length - 1);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		
		for(int i = 0; i < numbers.length - 1; i++) {
			if(numbers[i] > numbers[i + 1]) {
				System.err.println("Merge sort failed.");
				System.exit(0);
			}
		}
		
		
		System.out.println("Merge Sort: " +  duration / 1000000 + "ms");
		//ENDMERGESORT
		
		//SELECTIONSORT
		result = new int[sortable.length];
		for(int i = 0; i < sortable.length; i++) {
			result[i] = sortable[i];
		}
		
		startTime = System.nanoTime();
		result = selectionSort(result);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		
		for(int i = 0; i < result.length - 1; i++) {
			if(result[i] > result[i + 1]) {
				System.err.println("Selection sort failed.");
				System.exit(0);
			}
		}
		
		
		System.out.println("Selection Sort: " +  duration / 1000000 + "ms");
		//ENDSELECTIONSORT
		
		//INSERTIONSORT
		result = new int[sortable.length];
		for(int i = 0; i < sortable.length; i++) {
			result[i] = sortable[i];
		}
		
		startTime = System.nanoTime();
		result = insertionSort(result);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		
		for(int i = 0; i < result.length - 1; i++) {
			if(result[i] > result[i + 1]) {
				System.err.println("Insertion sort failed.");
				System.exit(0);
			}
		}
		
		
		System.out.println("Insertion Sort: " +  duration / 1000000 + "ms");
		//ENDINSERTIONSORT
		
		//BUBBLESORT
		result = new int[sortable.length];
		for(int i = 0; i < sortable.length; i++) {
			result[i] = sortable[i];
		}
		
		startTime = System.nanoTime();
		result = bubbleSort(result);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		
		for(int i = 0; i < result.length - 1; i++) {
			if(result[i] > result[i + 1]) {
				System.err.println("Bubble sort failed.");
				System.exit(0);
			}
		}

		System.out.println("Bubble Sort: " +  duration / 1000000 + "ms");
		//ENDBUBBLESORT
	}
	
	public static int[] bubbleSort(int[] nums) {
		boolean madeChange = true;
		int buffer;
		while(madeChange) {
			madeChange = false;
			for(int i = 0; i < nums.length - 1; i++) {
				if(nums[i] > nums[i + 1]) {
					buffer = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = buffer;
					madeChange = true;
				}	
			}
		}
		return nums;
	}
	
	public static int[] insertionSort(int[] nums) {
		int leastPos, buffer;
		for(int i = 0; i < nums.length; i++) {
			leastPos = i;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] < nums[leastPos]) {
					leastPos = j;
				}
			}
			buffer = nums[i];
			nums[i] = nums[leastPos];
			nums[leastPos] = buffer;
		}
		return nums;
	}
	
	public static int[] selectionSort(int[] nums) {
		if(nums.length == 1) {
			return nums;
		}
		
		int buffer;
		for(int i = 1; i < nums.length; i++) {
			for(int j = i; j > 0; j--) {
				if(nums[j] < nums[j - 1]) {
					buffer = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = buffer;
				}
			}
		}
		
		return nums;
	}
	
	private static void mergeSort(int low, int high) {
	    // check if low is smaller then high, if not then the array is sorted
	    if (low < high) {
	      // Get the index of the element which is in the middle
	      int middle = low + (high - low) / 2;
	      // Sort the left side of the array
	      mergeSort(low, middle);
	      // Sort the right side of the array
	      mergeSort(middle + 1, high);
	      // Combine them both
	      merge(low, middle, high);
	    }
	  }

	  private static void merge(int low, int middle, int high) {

	    // Copy both parts into the helper array
	    for (int i = low; i <= high; i++) {
	      helper[i] = numbers[i];
	    }

	    int i = low;
	    int j = middle + 1;
	    int k = low;
	    // Copy the smallest values from either the left or the right side back
	    // to the original array
	    while (i <= middle && j <= high) {
	      if (helper[i] <= helper[j]) {
	        numbers[k] = helper[i];
	        i++;
	      } else {
	        numbers[k] = helper[j];
	        j++;
	      }
	      k++;
	    }
	    // Copy the rest of the left side of the array into the target array
	    while (i <= middle) {
	      numbers[k] = helper[i];
	      k++;
	      i++;
	    }

	  }
}
