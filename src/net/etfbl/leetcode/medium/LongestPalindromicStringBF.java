package net.etfbl.leetcode.medium;

public class LongestPalindromicStringBF {
	
	public static String longestPalindrome(String s) {        
		 if (s.length() == 0)
	            return "";

	        int start = 0;
			int end = 0;

			for (int i = 0; i < s.length(); i++) {
				for (int j = i + 1; j < s.length(); j++) {
					if (s.charAt(i) == s.charAt(j) && (j - i) > (end - start)) {
						if (isPalindrome(s, i ,j)) {
							start = i;
							end = j;
						}
					}						
				}
			}

			return s.substring(start, end + 1);
    }
	
	private static boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime / 1000);
	}
	
}
