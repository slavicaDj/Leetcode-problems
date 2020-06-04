package net.etfbl.leetcode.easy;

public class CommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
        	return "";

		int i = 0;
		int endIndex = 0;
		while (true) { // loop through indexes 0,1,2,... until we encounter the end of any of the strings in strs
			if (i > strs[0].length() - 1)
				break;

			int counter = 0;
			char c = strs[0].charAt(i);

			for (int j = 1; j < strs.length; j++) { // loop through all the strings to check out index at i
				if (i > strs[j].length() - 1)
					return strs[0].substring(0, endIndex);
				
				if (strs[j].charAt(i) == c)
					counter++;
			}
			
        	if (counter == strs.length - 1) {
        		endIndex = i + 1;
        		i++;
        	}
        	else 
        		break;
        }
		
		return strs[0].substring(0, endIndex);
    }
	
	public static void main(String[] args) {
		String[] strings1 = {"flower","flow","flight"};
		String[] strings2 = {"dog","racecar","car"};
		System.out.println(longestCommonPrefix(strings1));
		System.out.println(longestCommonPrefix(strings2));
	}
}
