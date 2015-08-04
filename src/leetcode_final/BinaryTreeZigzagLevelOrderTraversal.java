package leetcode_final;
/*
 * Given a binary tree, return the zigzag level order 
 * traversal of its nodes' values. 
 * (ie, from left to right, then right to left for 
 * the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

 */
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> line;
		Stack<TreeNode> level = new Stack<TreeNode>();
		Stack<TreeNode> next_lev;
		if (root == null)
			return res;
		level.add(root);
		boolean flag = false;
		while (!level.isEmpty()) {
			line = new ArrayList<Integer>();
			next_lev = new Stack<TreeNode>();
			while(!level.isEmpty()) {
				TreeNode cur = level.pop();
				line.add(cur.val);
				if (flag) {
					if (cur.right != null)
						next_lev.add(cur.right);
					if (cur.left != null)
						next_lev.add(cur.left);
				} else {
					if (cur.left != null)
						next_lev.add(cur.left);
					if (cur.right != null)
						next_lev.add(cur.right);
				}
			}
			res.add(line);
			level = next_lev;
			flag = !flag;
		}
		return res;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		BinaryTreeZigzagLevelOrderTraversal test = new BinaryTreeZigzagLevelOrderTraversal();
		test.zigzagLevelOrder(root);
	}
}
