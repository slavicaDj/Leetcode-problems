package net.etfbl.leetcode.medium;

public class LongestPalindromicStringOpt {
	public static String longestPalindrome(String s) { 
		int start = 0, end = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int length1 = expand(s, i, i);
			int length2 = expand(s, i, i + 1);
			int length = Math.max(length1, length2);
			if (length > end - start) {
				start = i - (length - 1) / 2;
				end = i + length / 2;
			}
		}
		
		return s.substring(start, end + 1);
   }
	
	private static int expand(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		// i = 4, j = 5
		// 0 1 2 3 4 5 6 7 8 9
		// a b c g f f g r l o
		// i = 2, j = 7, 7 - 2 = 5; 
		// 5 - 1 = 4 <=> length
		return j - i - 1;
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime / 1000);
	}
}
