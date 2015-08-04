package leetcode_final;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * The brackets must close in the correct order,
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '(' || cur == '[' || cur == '{')
				stack.push(cur);
			else if (cur == ')') {
				if (stack.empty() || stack.pop() != '(')
					return false;
			} else if (cur == ']') {
				if (stack.empty() || stack.pop() != '[')
					return false;
			} else if (cur == '}') {
				if (stack.empty() || stack.pop() != '{')
					return false;
			}
		}
		if (!stack.empty())
			return false;
		return true;
	}
}
