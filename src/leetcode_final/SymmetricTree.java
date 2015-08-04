package leetcode_final;
/*
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 * For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
   3    3

Note:
Bonus points if you could solve it both recursively and iteratively.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return isSymmetric(root, root);
	}
	
	public boolean isSymmetric(TreeNode root1, TreeNode root2){
		if(root1 == null && root2 == null)
			return true;
		if(root1 != null && root2 != null)
			if(root1.val == root2.val)
				return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
		return false;
	}
	
	public boolean isSymmetric2(TreeNode root){
		// Start typing your Java solution below
		// DO NOT write main() function
		if(root == null)
			return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> traverse = new Stack<TreeNode>();
		TreeNode p = root;
		do{
			if(p != null){
				traverse.push(p);
				p = p.left;
			}
			else{
				p = traverse.pop();
				queue.offer(p);
				stack.push(p);
				p = p.right;
			}
		}while(!traverse.isEmpty() || p != null);
		while(!queue.isEmpty() && !stack.isEmpty()){
			TreeNode first = queue.poll();
			TreeNode last = stack.pop();
			if(first.val != last.val)
				return false;
		}
		if(queue.isEmpty() && stack.isEmpty())
			return true;
		else
			return false;
	}
	
	public static void main(String[] args){
		SymmetricTree.TreeNode root = new SymmetricTree.TreeNode(1);
		SymmetricTree test = new SymmetricTree();
		test.isSymmetric2(root);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
