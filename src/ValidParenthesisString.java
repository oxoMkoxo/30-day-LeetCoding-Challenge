
/* 678. Valid Parenthesis String
 * 
 *  Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether
 *  this string is valid. We define the validity of a string by these rules:
 *  Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 *  Any right parenthesis ')' must have a corresponding left parenthesis '('.
 *  Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 *  '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 *  An empty string is also valid.
 *  Example 1:
 *  	Input: "()"
 *  	Output: True
 *  Example 2:
 *  	Input: "(*)"
 *  	Output: True
 *  Example 3:
 *  	Input: "(*))"
 *  	Output: True
 *  Note:
 *  	The string size will be in the range [1, 100].
 * 
 */
import java.util.*;

public class ValidParenthesisString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		System.out.println(checkValidString(s));
		scn.close();
	}

	public static boolean checkValidString(String s) {
		Stack<Integer> leftStack = new Stack<>();
		Stack<Integer> starStack = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (ch == '(') {
				leftStack.push(i);
			} else if (ch == '*') {
				starStack.push(i);
			} else {
				if (!leftStack.isEmpty()) {
					leftStack.pop();
				} else if (!starStack.isEmpty()) {
					starStack.pop();
				} else {
					return false;
				}
			}
			i++;

		}
		while (!leftStack.isEmpty()) {
			if (!starStack.isEmpty() && starStack.peek() > leftStack.peek()) {
				starStack.pop();
				leftStack.pop();
			} else {
				return false;
			}
		}
		return true;
	}

}
