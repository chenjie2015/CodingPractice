package leetcode_final;
/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
最直接的思维是list赋值给array，O(n).
以下为bottom-up递归
 */
public class ConvertSortedListBST {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ListNode cur;

	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null)
			return null;
		int size = 1;
		ListNode ptr = head;
		this.cur = head;
		while (ptr.next != null) {
			ptr = ptr.next;
			size++;
		}
		return convert(0, size - 1);
	}

	public TreeNode convert(int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode left = convert(start, mid - 1);
		TreeNode parent = new TreeNode(cur.val);
		parent.left = left;
		cur = cur.next;
		parent.right = convert(mid + 1, end);
		return parent;
	}

}
