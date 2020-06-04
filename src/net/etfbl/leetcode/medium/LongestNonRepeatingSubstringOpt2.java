package net.etfbl.leetcode.medium;
import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubstringOpt2 {

	public static int lengthOfLongestSubstring(String s) {
		int low = 0, high = 0, max = 0, n = s.length();
		Set<Character> set = new HashSet<>();
		
		while (low < n && high < n) {
			if (!set.contains(s.charAt(high))) {
				set.add(s.charAt(high));
				high++;
				max = (max > (high - low))? max : high - low;
			}
			else {
				set.remove(s.charAt(low));
				low++;
			}
		}
		
		return max;
	}
	
    public static void main(String[] args) {
    	System.out.println(lengthOfLongestSubstring("aaaaa"));
    	System.out.println(lengthOfLongestSubstring("abcdae"));
    	System.out.println(lengthOfLongestSubstring("b"));
    	System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
