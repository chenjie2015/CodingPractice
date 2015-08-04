package leetcode_final;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root != null)
			inorder(res, root);
		return res;
	}

	public void inorder(ArrayList<Integer> res, TreeNode root) {
		if (root.left != null)
			inorder(res, root.left);
		res.add(root.val);
		if (root.right != null)
			inorder(res, root.right);
	}

	public ArrayList<Integer> inorderTraversal2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		do {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				res.add(p.val);
				p = p.right;
			}
		} while (!stack.empty() || p != null);
		return res;
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
