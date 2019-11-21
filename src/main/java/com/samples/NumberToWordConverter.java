package com.samples;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberToWordConverter {
	
private static final String ZERO = "zero";

	private static String[] oneToNine = {
	    "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
	};

	private static String[] tenToNinteen = {
	    "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
	};

	private static String[] tens = {
	    "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
	};

	public static void main(String[] args) {

		System.out.println("Enter any number between 0 and 999,999,999 to convert into words");
		Scanner sc = new Scanner(System.in);
		try {
			int num = sc.nextInt();
			System.out.println(convert(num));
		} catch (InputMismatchException ime) {
			System.out.println("Entered input is not a number. Please try again with a number within specified range.");
		} finally {
			sc.close();
		}
	}
	
	public static String convert(int number) {

		if(number == 0) {
		    return ZERO;
		}

		if(number < 0 || number > 999999999) {
		    return "Enter number is out of range [0 and 999,999,999]. Please try again with a number within specified range.";
		}

		return generate(number).trim();
	}
    
	private static String generate(int number) {

		if(number >= 1000000) {
		    return generate(number / 1000000) + " million " + generate(number % 1000000);
		}
		else if(number >= 1000) {
		    return generate(number / 1000) + " thousand " + generate(number % 1000);
		}
		else if(number >= 100) {
			String value = generate(number % 100);
		    return generate(number / 100) + " hundred" + ((value.equalsIgnoreCase("")) ? value : " and " + value);
		}

		return generate1To99(number);
	}

	private static String generate1To99(int number) {

		if (number == 0) {
		    return "";
		}

		if (number <= 9) {
		    return oneToNine[number - 1];
		} else if (number <= 19) {
		    return tenToNinteen[number % 10];
		} else {
		    return tens[number / 10 - 1] + " " + generate1To99(number % 10);
		}
	}
}
