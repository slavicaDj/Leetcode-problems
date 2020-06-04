package net.etfbl.leetcode.medium;
import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubstringOpt {

	public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0, low = 0, high = 0;
        
        while (low < n && high < n) {
        	System.out.println("low: " + low);
        	System.out.println("high: " + high);
        	System.out.println("max: " + max);
        	System.out.println("We check: Does " + s.charAt(high) + " exist in set?");
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(high))){ 
            	System.out.println("It doesn't, so we add it to set.");
                set.add(s.charAt(high));
                high++;
            	System.out.println("low stays the same: " + low);
            	System.out.println("new high: " + high);
                max = Math.max(max, high - low);
            	System.out.println("new max: " + max);
            }
            else {
            	System.out.println("It does.");
            	System.out.println("Remove char at low from set: " + s.charAt(low));
                set.remove(s.charAt(low));
                low++;
            	System.out.println("New low: " + low);
            }
            System.out.println("------------------");
        }
        return max;
    }
    
    public static void main(String[] args) {
    	System.out.println(lengthOfLongestSubstring("aaaaa"));
//    	System.out.println(lengthOfLongestSubstring("abcdae"));
    	System.out.println(lengthOfLongestSubstring("babcde"));
//    	System.out.println(lengthOfLongestSubstring("b"));
//    	System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
