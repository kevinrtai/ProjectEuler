package com.kevinrtai.euler;

public class Problem15 {

	//Finds the number of ways to travel through a 20x20 grid.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//I've really no idea why you would want to do this with a program.
		//Instead, think about it like this:
		//There are 40 decisions you can make in the route to the end of the grid.
		//20 down, 20 right
		//It's as if you were trying to find out how many ways there are to fill 40 spots
		//With 40 decisions.
		//The math can be made easier if you realize that it's simply the number of ways
		//to fill 20 spots(because the other 20 will be determined).
		//Therefore, it's just the number of ways to fill 40 spots with 20 choices.
		//Now, I suppose I'll promise myself to come back to figure out how to do this 
		//programmatically, but knowing me, I probably won't.
		System.out.println("40 C 20 = 137846528820");
	}

}
