package com.kevinrtai.euler.p11_20;


public class Problem17 {

	//Finds the number of letters if all the numbers from 1 to 1000 were written out
	//as words. God.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String current = "";
		int numberOfLetters = 0;
		for(int i = 1; i <= 1000; i++) {
			current = convertToNumber(i);
			numberOfLetters += current.length();
			System.out.println(i + ": "+ current);
		}
		
		System.out.println("Number of Letters: " + numberOfLetters);
	}

	public static String convertToNumber(int number){
		String src = Integer.toString(number);
		String output = "";
		char[] digits = src.toCharArray();		
		if(number > 0 && number < 10) {
			switch(digits[0]) {
			case '0':
				//Do nothing
				break;
			case '1':
				output += "one";
				break;
			case '2':
				output += "two";
				break;
			case '3':
				output += "three";
				break;
			case '4':
				output += "four";
				break;
			case '5':
				output += "five";
				break;
			case '6':
				output += "six";
				break;
			case '7':
				output += "seven";
				break;
			case '8':
				output += "eight";
				break;
			case '9':
				output += "nine";
				break;
			}
		}
		else {
			for(int i = digits.length - 1; i > 0; i--) {
				if(i == 3) {
					output += "onethousand";
				}
				else if(i == 2 && digits[digits.length - 3] != '0') {
					switch(digits[digits.length - 3]) {
					case '0':
						//Do nothing
						break;
					case '1':
						output += "one";
						break;
					case '2':
						output += "two";
						break;
					case '3':
						output += "three";
						break;
					case '4':
						output += "four";
						break;
					case '5':
						output += "five";
						break;
					case '6':
						output += "six";
						break;
					case '7':
						output += "seven";
						break;
					case '8':
						output += "eight";
						break;
					case '9':
						output += "nine";
						break;
					}
					output +="hundred";
					if(number % 100 == 0) {
						break;
					}
				}

				else if(i == 1 && digits[digits.length - 2] != '1') {
					if(digits.length>2 && (digits[digits.length - 3] != '0' ||
							number%100 != 0)) {
						output+="and";
					}
					switch(digits[digits.length - 2]) {
					case '0':
						//	Do nothing
						break;
					case '1':
						//This should never be called but whatever
						output += "oops";
						break;
					case '2':
						output += "twenty";
						break;
					case '3':
						output += "thirty";
						break;
					case '4':
						output += "forty";
						break;
					case '5':
						output += "fifty";
						break;
					case '6':
						output += "sixty";
						break;
					case '7':
						output += "seventy";
						break;
					case '8':
						output += "eighty";
						break;
					case '9':
						output += "ninety";
						break;
					}
					switch(digits[digits.length - 1]) {
					case '0':
						//	Do nothing
						break;
					case '1':
						output += "one";
						break;
					case '2':
						output += "two";
						break;
					case '3':
						output += "three";
						break;
					case '4':
						output += "four";
						break;
					case '5':
						output += "five";
						break;
					case '6':
						output += "six";
						break;
					case '7':
						output += "seven";
						break;
					case '8':
						output += "eight";
						break;
					case '9':
						output += "nine";
						break;
					}
				}
				else if (i == 1 && digits[digits.length - 2] == '1'){
					if(digits.length > 2 && number % 100 != 0) {
						output += "and";
					}
					switch(digits[digits.length-1]) {
					case '0':
						output += "ten";
						break;
					case '1':
						output += "eleven";
						break;
					case '2':
						output += "twelve";
						break;
					case '3':
						output += "thirteen";
						break;
					case '4':
						output += "fourteen";
						break;
					case '5':
						output += "fifteen";
						break;
					case '6':
						output += "sixteen";
						break;
					case '7':
						output += "seventeen";
						break;
					case '8':
						output += "eighteen";
						break;
					case '9':
						output += "nineteen";
						break;
					}
				}
			}
		}
		return output;
	}
}
