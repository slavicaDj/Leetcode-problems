package net.etfbl.leetcode.easy;

import java.util.HashMap;

public class RomanToInteger {
	
	/* 
	 *    I             1
	 * 	  V             5
	 *	  X             10
	 *	  L             50
	 *	  C             100
	 *	  D             500
	 *	  M             1000
	 */
	
	private HashMap<Character, Integer> map;
	
	public RomanToInteger() {
		this.map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);	
	}
	
	/*
	 * I can be placed before V (5) and X (10) to make 4 and 9. 
	 * X can be placed before L (50) and C (100) to make 40 and 90. 
	 * C can be placed before D (500) and M (1000) to make 400 and 900.
	 */
	public int romanToInt(String roman) {
		int result = 0;
		
		int i = 0;
		while (i < roman.length()) {
			char c = roman.charAt(i);

			if (i == roman.length() - 1) {
				result += map.get(c);
				break;
			}
			
			char c1 = roman.charAt(i + 1);

			switch(c) {
			case 'I':
				if (c1 == 'V' || c1 == 'X') {
					result += map.get(c1) - map.get(c);
					i += 2;
				}
				else {
					result += map.get(c);
					i++;
				}
				break;
				
			case 'X':				
				if (c1 == 'L' || c1 == 'C') {
					result += map.get(c1) - map.get(c);
					i += 2;
				}
				else {
					result += map.get(c);
					i++;
				}
				break;
				
			case 'C':				
				if (c1 == 'D' || c1 == 'M') {
					result += map.get(c1) - map.get(c);
					i += 2;
				}
				else {
					result += map.get(c);
					i++;
				}
				break;
				
			default:
				result += map.get(c);
				i++;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		RomanToInteger rti = new RomanToInteger();
		System.out.println(rti.romanToInt("III"));
		System.out.println(rti.romanToInt("IV"));
		System.out.println(rti.romanToInt("IX"));
		System.out.println(rti.romanToInt("LVIII"));
		System.out.println(rti.romanToInt("MCMXCIV"));
	}
}
