package geeksforgeeks;

import java.util.Stack;

/*
 * 1 Nov 2021
 */

/*
 * https://www.geeksforgeeks.org/expression-contains-redundant-bracket-not/
 */

public class ExpressionContainsRedundantBracketOrNot {
	
	public static void main(String[] args) {
		String str = "((a+b))";
		findRedundant(str);

		str = "(a+(b)/c)";
		findRedundant(str);

		str = "(a+b*(c-d))";
		findRedundant(str);
	}
	
	static void findRedundant(String str) {
        boolean ans = checkRedundancy(str);
        if (ans == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
	
	static boolean checkRedundancy(String s) {
		
		Stack<Character> st = new Stack<>();
		char[] str = s.toCharArray();
		
		for(char ch : str) {
			
			if(ch ==')') {
				char top = st.peek();
				st.pop();
				
				// If immediate pop have open parenthesis '('
                // duplicate brackets found
                boolean flag = true;
                
                while(top != '(') {
                	
                	if(top == '+' || top == '-' ||
                			top == '*' || top == '/') {
                		flag = false;
                	}
                	
                	top = st.peek();
                	st.pop();
                }
                
             // If operators not found
                if (flag == true) {
                    return true;
                }
			}else {
				st.push(ch);
			}
		}
		return false;
	}
}
