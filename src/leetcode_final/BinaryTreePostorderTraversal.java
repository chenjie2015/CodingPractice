package leetcode_final;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		TreeNode pre = null;
		TreeNode cur = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			cur = stack.peek();
			if (pre == null
					|| (pre != null && (pre.left == cur || pre.right == cur))) {
				if (cur.left != null)
					stack.push(cur.left);
				else if (cur.right != null)
					stack.push(cur.right);
			} else if (cur.left == pre) {
				if (cur.right != null)
					stack.push(cur.right);
			} else {
				res.add(stack.pop().val);
			}
			pre = cur;
		}
		return res;
	}
}
