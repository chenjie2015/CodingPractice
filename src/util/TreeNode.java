package util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}
	
	public static TreeNode construct(int[] array, int start, int end){
		if(start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(array[mid]);
		root.left = construct(array, start, mid - 1);
		root.right = construct(array, mid + 1, end);
		return root;
	}
	
	public static void printLevel(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		TreeNode cur;
		int first = 1, second = 0;
		while(!queue.isEmpty()){
			while(first != 0){
				cur = queue.poll();
				first--;
				System.out.print(cur.val + " ");
				if(cur.left != null){
					second++;
					queue.offer(cur.left);
				}
				if(cur.right != null){
					second++;
					queue.offer(cur.right);
				}
			}
			first = second;
			second = 0;
			System.out.println();
		}
	}

}
