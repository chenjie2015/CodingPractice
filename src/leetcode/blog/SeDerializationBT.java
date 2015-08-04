package leetcode.blog;

import java.util.ArrayList;
import util.TreeNode;

public class SeDerializationBT {
	/*
	 * Just Binary Tree
	 */
	public static void writeBT(ArrayList<Integer> array, TreeNode root){
		if(root == null)
			array.add(-1);
		else{
			array.add(root.val);
			writeBT(array, root.left);
			writeBT(array, root.right);
		}
	}
	
	public static int indexBT = 0;
	public static TreeNode readBT(ArrayList<Integer> array){
		int val = array.get(indexBT++);
		if(val < 0)
			return null;
		else{
			TreeNode root = new TreeNode(val);
			root.left = readBT(array);
			root.right = readBT(array);
			return root;
		}
	}
	/*
	 * Binary Search Tree
	 * Pre-order BST constructor
	 * No need to store -1 when serialize
	 */
	public static int index = 0;
	public static TreeNode preorderConstructBST(int[] array, int min, int max){
		if(index < array.length && array[index] < max && array[index] > min){
			TreeNode root = new TreeNode(array[index++]);
			root.left = preorderConstructBST(array, min, root.val);
			root.right = preorderConstructBST(array, root.val, max);
			return root;
		}
		return null;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		ArrayList<Integer> result = new ArrayList<Integer>();
		SeDerializationBT.writeBT(result, root);
		TreeNode new_root = SeDerializationBT.readBT(result);
		TreeNode.printLevel(new_root);
	}
}
