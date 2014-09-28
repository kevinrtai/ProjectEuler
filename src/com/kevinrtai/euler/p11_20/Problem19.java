package com.kevinrtai.euler.p11_20;

import java.util.ArrayList;

public class Problem19 {
	//Count the number of Sundays that are the first day
	//of the month from 1901 to 2000.

	//Here are some useful facts:
	//1 Jan 1900 was a Monday.
	//Thirty days has September,
	//April, June and November.
	//All the rest have thirty-one,
	//Saving February alone,
	//Which has twenty-eight, rain or shine.
	//And on leap years, twenty-nine.
	//A leap year occurs on any year evenly divisible by 4, 
	//but not on a century unless it is divisible by 400.
	
	private enum Day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}
	
	public static void main(String[] args) {
		ArrayList<Month> allMonths = new ArrayList<Month>();
		Month currentMonth = null;
		
		int days = 0;
		Month lastMonth = null;
		for(int i = 0; i < 12; i++) {
			System.out.println(i);
			if(i == 1) {
				if(1900 % 400 == 0 || (1900 % 4 == 0 && 1900 % 100 != 0)) {
					days = 29;
				}
				else {
					days = 28;
				}
			}
			else if(i == 3 || i == 5 || i == 8 || i == 10) {
				days = 30;
			}
			else {
				days = 31;
			}
			Day startDay;
			if(i == 0) {
				startDay = Day.MONDAY;
			}
			else {
				startDay = lastMonth.nextDay();
			}
			currentMonth = new Month(days, startDay);
			lastMonth = currentMonth;
		}
		
		System.out.println(lastMonth.nextDay());
		
		for(int i = 1901; i < 2001; i++) {
			for(int j = 0; j < 12; j++) {
				if(j == 1) {
					if(i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
						days = 29;
					}
					else {
						days = 28;
					}
				}
				else if(j == 3 || j == 5 || j == 8 || j == 10) {
					days = 30;
				}
				else {
					days = 31;
				}
				currentMonth = new Month(days, lastMonth.nextDay());
				allMonths.add(currentMonth);
				lastMonth = currentMonth;
			}
		}
		int sundays = 0;
		for(int i = 0; i < allMonths.size(); i++) {
			if(allMonths.get(i).firstDay() == Day.SUNDAY) {
				sundays++;
			}
		}
		System.out.println(sundays);
	}

	static class Month {
		private int days;
		private ArrayList<Day> month = new ArrayList<Day>();
		
		public Month(int days, Day start) {
			this.setDays(days);
			Day currentDay = start;
			for(int i = 0; i < days; i++) {
				month.add(currentDay);
				
				switch(currentDay) {
				case SUNDAY:
					currentDay = Day.MONDAY;
					break;
				case MONDAY:
					currentDay = Day.TUESDAY;
					break;
				case TUESDAY:
					currentDay = Day.WEDNESDAY;
					break;
				case WEDNESDAY:
					currentDay = Day.THURSDAY;
					break;
				case THURSDAY:
					currentDay = Day.FRIDAY;
					break;
				case FRIDAY:
					currentDay = Day.SATURDAY;
					break;
				case SATURDAY:
					currentDay = Day.SUNDAY;
					break;
				}
			}
		}

		public int getDays() {
			return days;
		}

		public void setDays(int days) {
			this.days = days;
		}
		
		private Day firstDay() {
			return month.get(0);
		}
		
		private Day nextDay() {
			Day currentDay = month.get(month.size() - 1);
			switch(currentDay) {
			case SUNDAY:
				currentDay = Day.MONDAY;
				break;
			case MONDAY:
				currentDay = Day.TUESDAY;
				break;
			case TUESDAY:
				currentDay = Day.WEDNESDAY;
				break;
			case WEDNESDAY:
				currentDay = Day.THURSDAY;
				break;
			case THURSDAY:
				currentDay = Day.FRIDAY;
				break;
			case FRIDAY:
				currentDay = Day.SATURDAY;
				break;
			case SATURDAY:
				currentDay = Day.SUNDAY;
				break;
			}
			return currentDay;
		}
	}
	
}
