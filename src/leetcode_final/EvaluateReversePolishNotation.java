package leetcode_final;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if (tokens.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (isOperator(tokens[i])) {
				int cur = calculate(stack.pop(), stack.pop(), tokens[i]);
				stack.push(cur);
			} else
				stack.push(Integer.parseInt(tokens[i]));
		}
		return stack.pop();
	}

	public boolean isOperator(String op) {
		if (op.equals("+") || op.equals("-") || op.equals("*")
				|| op.equals("/") || op.equals("%"))
			return true;
		return false;
	}

	public int calculate(int num2, int num1, String op) {
		if (op.equals("+"))
			return num1 + num2;
		else if (op.equals("-"))
			return num1 - num2;
		else if (op.equals("*"))
			return num1 * num2;
		else if (op.equals("/"))
			return num1 / num2;
		else if (op.equals("%"))
			return num1 % num2;
		else
			return 0;
	}
}
