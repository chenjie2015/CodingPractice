package leetcode_final;
/*
 * Given a sorted linked list,
 * delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesSortedListII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return head;
		ListNode res = new ListNode(0);
		res.next = head;
		ListNode pre = res;
		ListNode node = head;
		ListNode next = node.next;
		while (next != null) {
			if (node.val == next.val) {
				while (next != null && node.val == next.val) {
					next = next.next;
				}
				pre.next = next;
				node = next;
				if (next != null)
					next = next.next;
			} else {
				pre = pre.next;
				node = node.next;
				next = next.next;
			}
		}
		return res.next;
	}
}
