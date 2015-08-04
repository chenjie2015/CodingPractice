package leetcode_final;

public class SumRootLeafNum {
	public int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(root == null)
			return 0;
		return calculate(root, 0);
	}
	
	public int calculate(TreeNode root, int temp){
		temp = temp * 10 + root.val;
		if(root.left == null && root.right == null)
			return temp;
		int left = 0, right = 0;
		if(root.left != null)
			left = calculate(root.left, temp);
		if(root.right != null)
			right = calculate(root.right, temp);
		return left + right;
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
