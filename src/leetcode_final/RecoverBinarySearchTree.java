package leetcode_final;
/*
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?
 */
import java.util.ArrayList;
import java.util.Stack;

public class RecoverBinarySearchTree {
	// in order traversal to a stack uses O(n)
	public void recoverTree(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		ArrayList<TreeNode> inorder = new ArrayList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		do {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				inorder.add(p);
				p = p.right;
			}
		} while (!stack.empty() || p != null);
		int first = -1, second = -1;
		for (int i = 0; i < inorder.size() - 1; i++) {
			if (inorder.get(i).val > inorder.get(i + 1).val && first < 0)
				first = i;
			if (inorder.get(i).val > inorder.get(i + 1).val && first >= 0)
				second = i + 1;
		}
		int temp = inorder.get(first).val;
		inorder.get(first).val = inorder.get(second).val;
		inorder.get(second).val = temp;
	}
	
	// O(1) space solution
	public void recoverTree2(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(root == null)
			return;
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		inorderVisit(root, null, res);
		TreeNode first = res.get(0);
		TreeNode second = res.get(1);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}
	
	public TreeNode inorderVisit(TreeNode root, TreeNode pre, ArrayList<TreeNode> res){
		if(root == null)
			return pre;
		// last stores the last visited node
		// for left side "last visited node", it maybe root node or may not be.
		TreeNode last = inorderVisit(root.left, pre, res);
		if(last == null)
			last = root;
		if(root.val < last.val){
			if(res.isEmpty()){
				res.add(last);
				res.add(root);
			}
			else{
				res.remove(1);
				res.add(root);
			}
		}
		// for right side "last visited node", it should be root
		last = inorderVisit(root.right, root, res);
		return last == null ? root : last;
	}
	// in order traversal to a stack uses O(n)
	public void recoverTree3(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode first = null;
		TreeNode second = null;
		TreeNode pre = null;
		TreeNode p = root;
		do {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				p = stack.pop();
				if(pre == null)
					pre = p;
				else{
					if(pre.val > p.val){
						if(first == null){
							first = pre;
							second  = p;
							pre = p;
						}
						else{
							second = p;
							break;
						}
					} else
						pre = p;
				}
				p = p.right;
			}
		} while (!stack.empty() || p != null);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		//root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(1);
		RecoverBinarySearchTree test = new RecoverBinarySearchTree();
		test.recoverTree3(root);
	}
}
