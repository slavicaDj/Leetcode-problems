package net.etfbl.leetcode.hard;

import java.util.HashMap;

public class MinimumWindowSubstring2 {

	 public static String minWindow(String S, String T) {
	        int N = S.length(), M = T.length();
	        if (N < M) return new String("");
	        int[] need = new int[256];
	        int[] find = new int[256];
	        for (int i = 0; i < M; ++i)
	            need[T.charAt(i)]++;

	        int count = 0, resStart = -1, resEnd = N;
	        for (int start = 0, end = 0; end < N; ++end)
	        {
	        	
	            if (need[S.charAt(end)] == 0)
	                continue;
	            if (find[S.charAt(end)] < need[S.charAt(end)])
	                count++;
	            find[S.charAt(end)]++;
	            if (count != M) continue;
	            // move 'start'
	            for (; start < end; ++start) {
	                if (need[S.charAt(start)] == 0) continue;
	                if (find[S.charAt(start)] == need[S.charAt(start)]) break;
	                find[S.charAt(start)]--;
	            }
	            // update result
	            if (end - start < resEnd - resStart) {
	                resStart = start;
	                resEnd = end;
	            }
	        }
	        return (resStart == -1) ? new String("") : S.substring(resStart, resEnd + 1); 
	    }

	public static void main(String[] args) {
    	System.out.println(minWindow("geeksforgeeks", "ork"));
    }
		
}
