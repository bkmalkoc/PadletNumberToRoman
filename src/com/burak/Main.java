package com.burak;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	private final static TreeMap<Integer, String> romanMap = new TreeMap<Integer, String>();
	static {
		romanMap.put(1000, "M");
		romanMap.put(900, "CM");
		romanMap.put(500, "D");
		romanMap.put(400, "CD");
		romanMap.put(100, "C");
		romanMap.put(90, "XC");
		romanMap.put(50, "L");
		romanMap.put(40, "XL");
		romanMap.put(10, "X");
		romanMap.put(9, "IX");
		romanMap.put(5, "V");
		romanMap.put(4, "IV");
		romanMap.put(1, "I");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		String roman = "";

		while (number < 1 || number > 3999) {
			System.out.println("You entered a number out of Range. \nPlease enter a number in the range [1-3999]");
			number = scan.nextInt();
		}
		scan.close();

		roman = NumberToRoman(number);
		System.out.println(roman);
	}

	// There are few different ways to declare Convert Number to Roman scenario.
	// Easiest and clearest way is using Map
	public final static String NumberToRoman(int number) {
		int l = romanMap.floorKey(number);
		if (number == l) {
			return romanMap.get(number);
		}
		return romanMap.get(l) + NumberToRoman(number - l);
	}
}
