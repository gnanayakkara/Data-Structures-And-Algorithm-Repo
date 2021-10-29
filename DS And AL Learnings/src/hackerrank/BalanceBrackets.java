package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 */

public class BalanceBrackets {
	
	public static void main(String[] args) {
		
		String result = isBalanced("{[]()}");
		System.out.println(result);

	}
	
	public static String isBalanced(String ss) {
		
		Map<Character,Character> map = new HashMap<Character, Character>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');
		
		//LIFO
		Stack<Character> stack = new Stack<>();
		
		for(char c : ss.toCharArray()) {
			
			if(stack.isEmpty()) {
				
				stack.push(c);
				
			}else {
				
				if(map.get(stack.peek()) == null) {
					return "NO"; //open bracket is there
				}
				
				if(map.get(stack.peek()) == c) {
					stack.pop(); //if its match remove it from stack
				}else {
					stack.push(c); //if it not matching push to stack
				}
			}
		}
		
		if(!stack.isEmpty()){
			return "NO";
		}
		
		return "YES";
	}
	
}
