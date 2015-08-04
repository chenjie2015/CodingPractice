package linkedin;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import util.*;

public class DeepIterator {
	private Stack<Object> stack;

	public DeepIterator(List<Object> list) {
		stack = new Stack<Object>();
		stack.push(list);
		advanceToNext();
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		if (!hasNext())
			throw new RuntimeException("no next");

		int result = (Integer) stack.pop();
		advanceToNext();

		return result;
	}

	private void advanceToNext() {
		while (!stack.isEmpty() && !(stack.peek() instanceof Integer)) {
			Object obj = stack.pop();
			if (obj == null)
				continue;
			List<Object> cur = (List<Object>) obj;
			for (int i = cur.size() - 1; i >= 0; i--)
				stack.push(cur.get(i));
		}
	}
	
	public static void main(String[] args){
//		NestedListNode head = new NestedListNode(1, null, false);
//		head.next = new NestedListNode(2, null, false);
//		List<NestedListNode> list1 = new ArrayList<NestedListNode>();
//		list1.add(new NestedListNode(3, null, false));
//		list1.add(new NestedListNode(4, null, false));
//		List<NestedListNode> list11 = new ArrayList<NestedListNode>();
//		list11.add(new NestedListNode(5, null, false));
//		list11.add(new NestedListNode(6, null, false));
//		list1.add(new NestedListNode(-1, list11, true));
//		head.next.next = new NestedListNode(-1, list1, true);
//		head.next.next.next = new NestedListNode(7, null, false);
		List<Object> list = new ArrayList<Object>();
		list.add(new Integer(1));
		list.add(new Integer(2));
		List<Object> list1 = new ArrayList<Object>();
		list1.add(new Integer(3));
		list1.add(new Integer(4));
		List<Object> list11 = new ArrayList<Object>();
		list11.add(new Integer(5));
		list11.add(new Integer(6));
		list1.add(list11);
		list.add(list1);
		list.add(new Integer(7));
		DeepIterator it = new DeepIterator(list);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
