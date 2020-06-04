package net.etfbl.leetcode.medium;
import java.util.HashSet;

class LongestNonRepeatingSubstringBF {
	
    public static int lengthOfLongestSubstring(String s) {

        int max = -1;
        
        for (int i = 0; i < s.length(); i++) {
        	for (int j = i + 1; j <= s.length(); j++) {
        		if (isUnique(s, i, j) && (j - i) > max)
        			max = j - i;
        	}
        }
        
        return max;
      
    }
    
    private static boolean isUnique(String s, int low, int hi) {
        HashSet<String> lettersSet = new HashSet<>();

    	for (int i = low; i < hi; i++) {
    		String ch = String.valueOf(s.charAt(i));
    		if (lettersSet.contains(ch))
    			return false;
    		lettersSet.add(ch);
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	System.out.println(lengthOfLongestSubstring("aaaaa"));
    	System.out.println(lengthOfLongestSubstring("abcdae"));
    	System.out.println(lengthOfLongestSubstring("b"));
    	System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}