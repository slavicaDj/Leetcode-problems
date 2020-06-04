package net.etfbl.leetcode.medium;

public class LongestNonRepeatingSubstringBF2 {

    public static int lengthOfLongestSubstring(String s) {
    	int maxLength = 1;
    	
    	for (int i = 0; i < s.length(); i++) {
    		int length = 1;
    		for (int j = i + 1; j < s.length(); j++) {
    			if (s.charAt(i) != s.charAt(j))
    				length++;
    			else {
    				maxLength = (length > maxLength)? length : maxLength;
    				break;
    			}
    		}
    	}
    	
    	return maxLength;
    }
    
    public static void main(String[] args) {
    	System.out.println(lengthOfLongestSubstring("aaaaa"));
    	System.out.println(lengthOfLongestSubstring("abcdae"));
    	System.out.println(lengthOfLongestSubstring("b"));
    	System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
