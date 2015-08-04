package random;

import java.util.Stack;

public class StackWithMin {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();

	public void push(Integer val) {
		stack.push(val);
		if (min.isEmpty() || val <= min.peek())
			min.push(val);
	}

	public Integer pop() {
		if (!stack.isEmpty() && !min.isEmpty()) {
			Integer val = stack.pop();
			if (val == min.peek())
				min.pop();
		}
		return Integer.MIN_VALUE;
	}

	public Integer getMin() {
		if (!min.isEmpty())
			return min.peek();
		return Integer.MIN_VALUE;
	}
}