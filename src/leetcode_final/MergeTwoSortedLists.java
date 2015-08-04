package leetcode_final;
/*
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head, node;
		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		node = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				node = node.next;
				l1 = l1.next;
			} else {
				node.next = l2;
				node = node.next;
				l2 = l2.next;
			}
		}
		if (l1 != null)
			node.next = l1;
		if (l2 != null)
			node.next = l2;
		return head;
	}

	// New techniques applied. 不用处理第一个，生成一个head保留位置，返回时返回head.next。
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = new ListNode(0);
		ListNode node = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				node = node.next;
				l1 = l1.next;
			} else {
				node.next = l2;
				node = node.next;
				l2 = l2.next;
			}
		}
		if (l1 != null)
			node.next = l1;
		if (l2 != null)
			node.next = l2;
		return head.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
