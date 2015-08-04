package leetcode_final;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */
public class MergeKSortedLists {

	/*
	 * 直接brute force是O（n*K），n是节点总个数，每次取一个节点的时候都要比较K个head。
	 * 使用heap是O（n*logK），每次从heap取出是logK。
	 */
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (lists == null || lists.size() == 0)
			return null;
		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			public int compare(ListNode m, ListNode n) {
				if (m.val == n.val)
					return 0;
				else if (m.val > n.val)
					return 1;
				else
					return -1;
			}
		};
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
				comparator);
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null)
				q.add(lists.get(i));
		}
		ListNode head = null, cur = null;
		while (!q.isEmpty()) {
			if (head == null) {
				head = q.poll();
				cur = head;
			} else {
				cur.next = q.poll();
				cur = cur.next;
			}
			if (cur.next != null)
				q.add(cur.next);
		}
		return head;
	}

	/*
	 * n 是链表的平均长度 利用分治的思想把合并k个链表分成两个合并k/2个链表的任务，一直划分，知道任务中只剩一个链表或者两个链表。
	 * 可以很简单的用递归来实现。因此算法复杂度为T(k) = 2T(k/2) + O(nk),很简单可以推导得到算法复杂度为O（nklogk）
	 * 1、3合并，合并结果放到1的位置 2、4合并，合并结果放到2的位置 再把1、2合并（相当于原来的13 和 24合并）
	 */
	public ListNode mergeKLists2(ArrayList<ListNode> lists) {
		int n = lists.size();
		if (n == 0)
			return null;
		while (n > 1) {
			int k = (n + 1) / 2;
			for (int i = 0; i < n / 2; i++)
				lists.set(i, merge2list2(lists.get(i), lists.get(i + k)));
			n = k;
		}
		return lists.get(0);
	}

	public ListNode merge2list2(ListNode head1, ListNode head2) {
		ListNode node, res = new ListNode(Integer.MIN_VALUE);
		node = res;
		while (head1 != null && head2 != null) {
			if (head1.val <= head2.val) {
				res.next = head1;
				head1 = head1.next;
			} else {
				res.next = head2;
				head2 = head2.next;
			}
			res = res.next;
		}
		if (head1 != null)
			res.next = head1;
		else if (head2 != null)
			res.next = head2;
		return node.next;
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
