package net.etfbl.leetcode.medium;
import java.util.ArrayList;
import java.util.List;

public class ZigZag {
	
	public static String convert(String s, int numRows) {
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
        	rows.add(new StringBuilder());
        
        int row = 0, dir = 1;

        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	rows.get(row).append(c);
        	row = row + dir;
        	if (row == numRows - 1 && dir == 1)
        		dir = -1;
        	else if (row == 0 && dir == -1)
        		dir = 1;
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
        	result.append(sb);
        }
        
        return result.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(convert("slavica", 3));
	}
}
