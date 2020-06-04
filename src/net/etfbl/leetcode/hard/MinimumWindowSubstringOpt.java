package net.etfbl.leetcode.hard;
/* 
 * credit: https://github.com/cherryljr/LeetCode/blob/master/Minimum%20Window%20Substring.java 
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringOpt {

    public static String getMinWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> letterFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            letterFreq.put(c, letterFreq.getOrDefault(c, 0) + 1);
        }

        // record the min window's start position
        int startIndex = 0, minSubstringLength = Integer.MAX_VALUE;
        int count = letterFreq.size();
        
        // left side (low) and right side (hi) of sliding window
        for (int low = 0, hi = 0; hi < s.length(); hi++) {
           System.out.println("low: " + low);
           System.out.println("hi: " + hi);
        	char hiLetter = s.charAt(hi);
        	System.out.println("hiLetter: " + hiLetter);
        	
            if (letterFreq.containsKey(hiLetter)) {
            	System.out.println("Map contains " + hiLetter + " with frequency: " + letterFreq.get(hiLetter));
                letterFreq.put(hiLetter, letterFreq.get(hiLetter) - 1);
            	System.out.println("New frequency: " + letterFreq.get(hiLetter));
                if (letterFreq.get(hiLetter) == 0) {
                    count -= 1;
                	System.out.println("Frequency is 0, so we decrement count: " + count);
                }
            }

            while (count <= 0) {
                char lowLetter = s.charAt(low);
                System.out.println("Count: " + count);
                System.out.println("lowLetter: " + lowLetter);
                if (letterFreq.containsKey(lowLetter)) {
                    System.out.println("Letter is in the map -> increase its frequency because it's going out of the window");
                    letterFreq.put(lowLetter, letterFreq.get(lowLetter) + 1);
                    System.out.println("New frequency: " + letterFreq.get(lowLetter));
                    // map.get(cLeft) means cLeft is the start character(position) of curr window
                    // pay attention to the duplicated characters.
                    if (letterFreq.get(lowLetter) >= 1) {
                        count += 1;
                        System.out.println("New frequency is >= 1, increase count: " + count);
                    }
                }
                // Get the min window
                if (hi - low + 1 < minSubstringLength) {
                    startIndex = low;
                    minSubstringLength = hi - low + 1;
                }
                
                low++;
                System.out.println("Increment low: " + low);
                System.out.println("-----------------------");
            }
            System.out.println("******************************");
        }
        return minSubstringLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minSubstringLength);
    }
    
    public static void main(String[] args) {
    	System.out.println(getMinWindow("aaaaaaaaaaa", "aa"));
    }
}
