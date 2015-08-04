package leetcode_final;

import java.util.ArrayList;

public class PathSumII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		traversal(res, path, root, sum);
		return res;
	}

	public void traversal(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> path, TreeNode root, int sum) {
		if (root == null)
			return;
		path.add(root.val);
		sum = sum - root.val;
		if (root.left == null && root.right == null && sum == 0)
			res.add(new ArrayList<Integer>(path));
		traversal(res, path, root.left, sum);
		traversal(res, path, root.right, sum);
		path.remove(path.size() - 1);
	}

}
