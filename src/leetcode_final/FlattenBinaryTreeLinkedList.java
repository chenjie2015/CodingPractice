package leetcode_final;

import java.util.Stack;

/*
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given

 *        1
 *       / \
 *      2   5
 *     / \   \
 *    3   4   6
 * The flattened tree should look like:
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 * Hints:
 * If you notice carefully in the flattened tree,
 * each node's right child points to the next node of a pre-order traversal.
 */
public class FlattenBinaryTreeLinkedList {

	public void flatten(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode node = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (node != null) {
				node.left = null;
				node.right = cur;
			}
			node = cur;
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}

	// Recursive solution
	TreeNode res = new TreeNode(0);
	Stack<TreeNode> stk = new Stack<TreeNode>();

	public void flatten2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		if (root != null) {
			res.left = null;
			res.right = root;
			res = root;
		}
		if (root.right != null) {
			stk.push(root.right);
		}
		if (root.left != null) {
			stk.push(root.left);
		}
		if (!stk.isEmpty()) {
			flatten(stk.pop());
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
}
