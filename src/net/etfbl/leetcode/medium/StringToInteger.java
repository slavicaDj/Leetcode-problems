package net.etfbl.leetcode.medium;

public class StringToInteger {
	
	public int myAtoi(String str) {
		if (str == null || str.length() == 0)
			return 0;

        if (!(str.charAt(0) == ' ' || str.charAt(0) >= '0' || str.charAt(0) <= '9'))
        	return 0;
        
        long result = 0;
        int i = 0;
        // eat the whitespace
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i == str.length())
        	return 0;
        
        int sign = 1;
        if (str.charAt(i) == '+') {
        	i++;
        	sign = 1;
        }
        else if (str.charAt(i) == '-') {
        	i++;
        	sign = -1;
        }
   
        for (; i < str.length(); i++) {
        	char c = str.charAt(i);
        	if (c < '0' || c > '9')
        		break;
        	result =  result * 10 + Character.getNumericValue(c);

        	if (sign * result < Integer.MIN_VALUE)
        		return Integer.MIN_VALUE;
        	if (sign * result > Integer.MAX_VALUE)
        		return Integer.MAX_VALUE;
        }
      
        return (int)(sign * result);
    }
	
	public static void main(String[] args) {
		StringToInteger stoi = new StringToInteger();
		System.out.println(stoi.myAtoi("-42 with words"));
		System.out.println(stoi.myAtoi("42"));
		System.out.println(stoi.myAtoi("      +42"));
		System.out.println(stoi.myAtoi("      42"));
		System.out.println(stoi.myAtoi("      -42"));
		System.out.println(stoi.myAtoi("4193 with words"));
		System.out.println(stoi.myAtoi("-91283472332"));
		System.out.println(stoi.myAtoi("          "));

	}
}
