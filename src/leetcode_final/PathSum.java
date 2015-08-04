package leetcode_final;

public class PathSum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return false;
		sum = sum - root.val;
		if (root.left == null && root.right == null && sum == 0)
			return true;
		boolean left = false, right = false;
		if (root.left != null)
			left = hasPathSum(root.left, sum);
		if (root.right != null)
			right = hasPathSum(root.right, sum);
		return left || right;
	}

}
