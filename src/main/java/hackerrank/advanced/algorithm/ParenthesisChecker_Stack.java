/**
 * 
 */
package hackerrank.advanced.algorithm;

import java.util.Stack;

/**
 * @author Arbind Negi 19-Jun-2022
 *
 */
public class ParenthesisChecker_Stack {

    /**
     * @param args
     */
    public static void main(String[] args) {
	//String str = "{([])}";
	String str = "()}";
	boolean isCorrect = isParenthesis(str);
	System.out.println(isCorrect);

    }

  //Function to check if brackets are balanced or not.
    static boolean isParenthesis(String input) {
	Stack<Character> stack = new Stack<>();
	
	for (int i = 0; i < input.length(); i++) {
	    char ch = input.charAt(i);
	    if (ch == '}') {
		if (!stack.empty() && stack.peek() == '{') {
		    stack.pop();
		} else
		    return false;

	    } else if (ch == ']') {
		if (!stack.empty() && stack.peek() == '[') {
		    stack.pop();
		} else
		    return false;

	    } else if (ch == ')') {
		if (!stack.empty() && stack.peek() == '(') {
		    stack.pop();
		} else
		    return false;
	    } else {
		stack.push(ch);
	    }
	}
	if (stack.empty()) {
	    return true;
	} else
	    return false;
    }
}
