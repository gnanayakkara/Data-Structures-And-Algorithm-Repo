package leetcode;

import java.util.Stack;

/*
 * 27 May 2022
 * https://leetcode.com/problems/valid-parentheses/
 */

public class ValidParentheses {
	
	public static void main(String[] args) {
		
		String input = "{}[{}()]";
		System.out.println(isValid(input));
	}
	
	public static boolean isValid(String s) {
	    
		Stack<Character> stack = new Stack<Character>();
		
		for(Character character : s.toCharArray()) {
			
			if(stack.isEmpty()) {
				
				if(character == '}' || character == ')' || character == ']') {
					return false;//Found open bracket
				}else{
					stack.push(character);
				}
				
			}else {
				
				if(character == '}' && stack.peek() == '{') {
					stack.pop();
				}else if(character == ']' && stack.peek() == '[') {
					stack.pop();
				}else if(character == ')' && stack.peek() == '(') {
					stack.pop();
				}else {
					stack.push(character);
				}
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		
		return false;

	}
}

