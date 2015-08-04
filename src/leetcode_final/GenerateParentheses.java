package leetcode_final;

import java.util.ArrayList;

/*
 *  Given n pairs of parentheses,
 *  write a function to generate all combinations of well-formed parentheses.
 *  
 *  For example, given n = 3, a solution set is:
 *  "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
	public ArrayList<String> res;

	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		res = new ArrayList<String>();
		generate(0, 0, n, "");
		return res;
	}

	public void generate(int left, int right, int n, String temp) {
		if (right == n)
			res.add(temp);
		if (left < n)
			generate(left + 1, right, n, temp + "(");
		if (right < left)
			generate(left, right + 1, n, temp + ")");
	}
}
