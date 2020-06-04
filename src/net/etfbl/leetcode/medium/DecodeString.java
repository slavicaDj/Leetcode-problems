package net.etfbl.leetcode.medium;
import java.util.Stack;

public class DecodeString {

	/* valid only for numbers smaller than 10 */
	public String decodeString(String s) {
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
	
		for (int  i = 0; i < s.length(); i++) {
			String ch = String.valueOf(s.charAt(i));
	
			if (stack.isEmpty()) {
				if (isNumber(ch)) {
					stack.push(ch);
					/* skip the opening bracket */
					i++; 
				}
				else {
					sb.append(ch); 
				}
				/* note: we cannot reach closing bracket if stack is empty */
			}
			/* stack is not empty */
			else {
				if(isNumber(ch)) {
					stack.push(ch);
					i++;
				}
				else if (ch.equals("]")) {
					String subString = "";
			
					while (true) {
						String stackItem = stack.pop();
						
						if (isNumber(stackItem)) {
					         Integer stackNumber = Integer.valueOf(stackItem);
			                 String mulSubstring = multiply(stackNumber, subString);
					        
			                 if (stack.isEmpty())
					        	sb.append(mulSubstring);
					         else
					        	 stack.push(mulSubstring);
			                 
					         break;
						}
						else
							subString = stackItem + subString;
					}
				}
				/* letter */
				else {
					stack.push(ch);
				}
			}	
		}
		return sb.toString();
	}
	
	private String multiply(int n, String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(s);
		return sb.toString();
	}

	private boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "3[a2[c]]";
		DecodeString decoder = new DecodeString();
		System.out.println(decoder.decodeString(s));
	}
}
