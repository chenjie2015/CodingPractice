package leetcode_final;
/*
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

    You may only use constant extra space.

For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
public class PopulateNextRightPointerII {
	//用next_head和last_node来记录下一个需要处理的根节点以及前一次处理完剩下的最右节点。算法简单但是代码复杂。
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		TreeLinkNode cur_head = root;
		while (cur_head != null) {
			TreeLinkNode cur = cur_head;
			TreeLinkNode next_head = null;
			TreeLinkNode last_node = null;
			while (cur != null) {
				if (cur.left == null && cur.right == null)
					;
				else if (cur.left != null && cur.right != null) {
					if (last_node != null)
						last_node.next = cur.left;
					cur.left.next = cur.right;
					last_node = cur.right;
					if (next_head == null)
						next_head = cur.left;
				} else {
					TreeLinkNode child = null;
					if (cur.left != null)
						child = cur.left;
					else
						child = cur.right;
					if (last_node != null)
						last_node.next = child;
					last_node = child;
					if (next_head == null)
						next_head = child;
				}
				cur = cur.next;
			}
			if (last_node != null)
				last_node.next = null;
			cur_head = next_head;
		}
	}

	//递归解法，用p指向该指向的next节点，逐层的时候从右向左遍历。避免了next_head的处理。 
	public void connect2(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null) {
			return;
		}
		TreeLinkNode cur = root.next;
		TreeLinkNode p = null;
		while (cur != null) { // find last right node (left or right)
			if (cur.left != null) {
				p = cur.left;
				break;
			}
			if (cur.right != null) {
				p = cur.right;
				break;
			}
			cur = cur.next;
		}
		if (root.right != null) 
			root.right.next = p;
		if (root.left != null)
			root.left.next = root.right != null ? root.right : p;
		connect2(root.right); // from right to left
		connect2(root.left);
	}
	
	//也可以写成从左向右的。下面左向右代码无法通过judge large，因为每层的节点(root.left)重复操作了，需要设置一个量来保存每层的最左的根。
	public void connect3(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		TreeLinkNode cur = root.next;
		TreeLinkNode p = null;
		while (cur != null) { // find last right node (left or right)
			if (cur.left != null) {
				p = cur.left;
				break;
			}
			if (cur.right != null) {
				p = cur.right;
				break;
			}
			cur = cur.next;
		}
		if (root.left != null)
			root.left.next = root.right != null ? root.right : p;
		if (root.right != null) 
			root.right.next = p;
		if(cur != null)
			connect3(cur);
		connect3(root.left);
	}

	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(3);
		root.right.right = new TreeLinkNode(3);
		root.left.left.left = new TreeLinkNode(4);
		root.right.right.right = new TreeLinkNode(4);
		PopulateNextRightPointerII test = new PopulateNextRightPointerII();
		test.connect(root);
	}
}
