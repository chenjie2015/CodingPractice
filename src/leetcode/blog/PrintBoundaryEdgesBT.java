package leetcode.blog;

import java.util.ArrayList;

import util.TreeNode;

public class PrintBoundaryEdgesBT {
	// Q14 Print boundary edges of a binary tree
	public static ArrayList<Integer> printEdges(TreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		res.add(root.val);
		printLeftBottomEdges(root.left, true, res);
		printBottomRightEdges(root.right, true, res);
		return res;
	}
	public static void printLeftBottomEdges(TreeNode root, boolean print, ArrayList<Integer> res){
		if(root == null)
			return;
		if(print || (root.left == null && root.right == null))
			res.add(root.val);
		printLeftBottomEdges(root.left, print, res);
		printLeftBottomEdges(root.right, print && root.left == null ? true : false, res);
	}
	public static void printBottomRightEdges(TreeNode root, boolean print, ArrayList<Integer> res){
		if(root == null)
			return;
		printBottomRightEdges(root.left, print && root.right == null ? true : false, res);
		printBottomRightEdges(root.right, print, res);
		if(print || (root.left == null && root.right == null))
			res.add(root.val);
	}
}
