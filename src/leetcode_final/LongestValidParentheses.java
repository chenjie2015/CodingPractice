package leetcode_final;

import java.util.Stack;

/*
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())",
 * where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = s.length();
		int max = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(')
				stack.push(i);
			else {
				if (!stack.empty() && s.charAt(stack.peek()) == '(') {
					stack.pop();
					if (stack.empty())
						max = Math.max(max, i + 1);
					else {
						max = Math.max(max, i - stack.peek());
					}
				} else
					stack.push(i);
			}
		}
		return max;
	}

	// Same idea. Using arrays instead of a stack.
	public int longestValidParentheses2(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0)
			return 0;
		int l = s.length();
		int dp[] = new int[l];// dp[i] stores current longest length
		int max = 0, j;

		for (int i = 1; i < l; i++) {
			if (s.charAt(i) == ')') {
				j = i - 1 - dp[i - 1];
				if (j >= 0 && s.charAt(j) == '(')
					dp[i] = i - j + 1 + ((j > 0) ? dp[j - 1] : 0);
			}
			if (dp[i] > max)
				max = dp[i];
		}
		return max;
	}
}
