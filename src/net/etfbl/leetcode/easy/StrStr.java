package net.etfbl.leetcode.easy;

public class StrStr {

	public int strStr(String haystack, String needle) { 
        if (needle == null || needle.length() == 0 || needle.equals(""))
            return 0;

        outer:
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = i;
              
                for (int j = 0; j < needle.length() && k < haystack.length(); j++, k++) {
                    if (haystack.charAt(k) != needle.charAt(j))
                        continue outer;
                }
                if (k - i == needle.length())
                    return i;
            }
        }
                
        return -1;
    }
	
	public static void main(String[] args) {
		String a = "mississippi";
		String b = "issip";
		
		System.out.println(new StrStr().strStr(a, b));
	}
}
