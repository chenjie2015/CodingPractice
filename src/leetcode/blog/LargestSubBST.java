package leetcode.blog;

import util.TreeNode;

public class LargestSubBST {
	//Q 17
	/*
	 * 包含所有子节点
	 */
	// Largest Subtree which is a BST
	static TreeNode largestSubRoot = null;
	static int min, max, maxNodes;
	// min and max are for subtree, so the root.val should be outside of [min, max]
	public static TreeNode largestSubtree(TreeNode root){
		findLargestSubtree(root);
		return largestSubRoot;
	}
	public static int findLargestSubtree(TreeNode root){
		if(root == null)
			return 0;
		boolean isBST = true;
		int leftNodes = findLargestSubtree(root.left);
		int curMin = (leftNodes == 0) ? root.val : min;
		if(leftNodes == -1 || (leftNodes != 0 && root.val <= max)) // root.val in the range of subtree values, thus not BST
			isBST = false;
		int rightNodes = findLargestSubtree(root.right);
		int curMax = (rightNodes == 0) ? root.val : max;
		if(rightNodes == -1 || (rightNodes != 0 && root.val >= min)) // root.val in the range of subtree values, thus not BST
			isBST = false;
		if(isBST){
			min = curMin;
			max = curMax;
			int totalNodes = leftNodes + rightNodes + 1;
			if(totalNodes > maxNodes){
				maxNodes = totalNodes;
				largestSubRoot = root;
			}
			return totalNodes;
		} else
			return -1;
	}
	
	// Q18
	// 不一定包含所有子节点
		static int maxNodesBST;
		static TreeNode largestBST;
		static TreeNode child;
		public int findLargestBST(TreeNode root, int min, int max){
			if(root == null)
				return 0;
			if(min < root.val && root.val < max){
				int leftNodes = findLargestBST(root.left, min, root.val);
				TreeNode leftChild = (leftNodes == 0) ? null : child;
				int rightNodes = findLargestBST(root.right, root.val, max);
				TreeNode rightChild = (rightNodes == 0) ? null : child;
				TreeNode parent = new TreeNode(root.val);
				parent.left = leftChild;
				parent.right = rightChild;
				child = parent;
				int totalNodes = leftNodes + rightNodes + 1;
				if(totalNodes > maxNodes){
					maxNodes = totalNodes;
					largestBST = parent;
				}
				return totalNodes;
			} else {
				findLargestBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
				return 0;
			}
		}
		
}
