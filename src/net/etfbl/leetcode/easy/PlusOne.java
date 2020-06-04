package net.etfbl.leetcode.easy;

import java.util.Arrays;

public class PlusOne {

	/* credit: leetcode */
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] + 1 < 9) {
				digits[i]++;
				return digits;
			}
			else
				digits[i] = 0;
		}
		
		int[] newDigits = new int[n + 1];
		newDigits[0] = 1;
		for (int i = 1; i < digits.length; i++) {
			newDigits[i] = digits[i];
		}
		
		return newDigits;
    }
	
	public static void main(String[] args) {
		int[] arr = {9,8,7,6,5,4,3,2,1,0};
		PlusOne plus = new PlusOne();
		System.out.println(Arrays.toString(plus.plusOne(arr)));
	}
}
