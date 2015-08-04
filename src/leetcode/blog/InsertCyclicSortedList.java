package leetcode.blog;

import util.*;

public class InsertCyclicSortedList {
	public static LinkedListNode insert(LinkedListNode head, int x) {
		if (head == null) {
			head = new LinkedListNode(x);
			head.next = head;
			return head;
		}

		LinkedListNode cur = head;
		LinkedListNode pre = null;
		do {
			pre = cur;
			cur = cur.next;
			if (x <= cur.value && x >= pre.value)
				break; // For case 1, find insert position
			if ((pre.value > cur.value) && (x < cur.value || x > pre.value))
				break; // For case 2, x is either max or min
		} while (cur != head);
		// when back to starting point, then stop.
		// For case 3, list has only one node

		LinkedListNode newNode = new LinkedListNode(x);
		newNode.next = cur;
		pre.next = newNode;
		return head;
	}
}
