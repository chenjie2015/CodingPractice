package random;

import java.util.LinkedList;
import java.util.Queue;

public class QueueWithMin {
	Queue<Integer> queue = new LinkedList<Integer>();
	LinkedList<Integer> min = new LinkedList<Integer>();

	public void offer(Integer val) {
		queue.offer(val);
		if (min.isEmpty())
			min.offer(val);
		else {
			while (!min.isEmpty() && min.peekLast() > val)
				min.pollLast();
			min.offerLast(val);
		}
	}

	public Integer poll() {
		Integer val = Integer.MIN_VALUE;
		if (!queue.isEmpty() && !min.isEmpty()) {
			val = queue.poll();
			if (min.peek() == val)
				min.poll();
		}
		return val;
	}

	public Integer getMin() {
		return min.peek();
	}

	public static void main(String[] args) {
		QueueWithMin queue = new QueueWithMin();
		queue.offer(12);
		System.out.println(queue.getMin());
		queue.offer(5);
		System.out.println(queue.getMin());
		queue.offer(10);
		System.out.println(queue.getMin());
		queue.offer(7);
		System.out.println(queue.getMin());
		queue.offer(11);
		System.out.println(queue.getMin());
		queue.offer(19);
		System.out.println(queue.getMin());
		queue.poll();
		System.out.println(queue.getMin());
		queue.poll();
		System.out.println(queue.getMin());
		queue.poll();
		System.out.println(queue.getMin());
	}
}
