package leetcode_final;
/*
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArrayBST {
	public TreeNode sortedArrayToBST(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(num.length == 0)
			return null;
		return build(num, 0, num.length - 1);
	}

	public TreeNode build(int[] num, int s, int e){
		if(s > e)
			return null;
		int m = (s + e) / 2;
		TreeNode root = new TreeNode(num[m]);
		root.left = build(num, s, m - 1);
		root.right = build(num, m + 1, e);
		return root;
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
