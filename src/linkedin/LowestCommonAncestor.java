package linkedin;

import java.util.ArrayList;
import java.util.Stack;

public class LowestCommonAncestor {
	// best solution ever
	// without parent pointer
	// without storage of path
	public Node lowestCommonAncestor(Node root, Node p, Node q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;
		Node left = lowestCommonAncestor(root.left, p, q);
		Node right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) // p and q are on both sides
			return root; // root is the result
		return left == null ? right : left;
	}

	// without parent pointer
	// store paths
	public TreeNode LowestCommonFather(TreeNode h, TreeNode n1, TreeNode n2) {
		if (h == null || n1 == null || n2 == null)
			return null;
		Stack<TreeNode> path1 = new Stack<TreeNode>();
		Stack<TreeNode> path2 = new Stack<TreeNode>();
		boolean f1 = getPath(h, n1, path1);
		boolean f2 = getPath(h, n2, path2);
		if (!f1 || !f2)
			return null;
		TreeNode commonP = null;
		while (!path1.isEmpty() && !path2.isEmpty()) {
			TreeNode p1 = path1.pop();
			TreeNode p2 = path2.pop();
			if (p1 == p2)
				commonP = p1;
			else
				break;
		}
		return commonP;
	}

	public boolean getPath(TreeNode h, TreeNode n, Stack<TreeNode> stack) {
		if (h == null)
			return false;
		stack.push(h);
		if (h == n)
			return true;
		boolean finded = false;
		for (TreeNode chd : h.childList) {
			if (finded)
				break;
			finded = getPath(chd, n, stack);
		}
		if (!finded)
			stack.pop();
		return finded;
	}

	// with parent pointer
	// 1. use a hashtable to store all the visited node in the first path
	// whenever encounter a visited node scanning the second path
	// return the result
	// 2. store paths
	public TreeNode LowestCommonFather2(TreeNode n1, TreeNode n2) {
		if (n1 == null || n2 == null)
			return null;
		Stack<TreeNode> path1 = new Stack<TreeNode>();
		Stack<TreeNode> path2 = new Stack<TreeNode>();
		TreeNode parent = n1;
		while (parent != null) {
			path1.push(parent);
			parent = parent.parent;
		}
		parent = n2;
		while (parent != null) {
			path2.push(parent);
			parent = parent.parent;
		}
		TreeNode commonP = null;
		while (!path1.isEmpty() && !path2.isEmpty()) {
			TreeNode p1 = path1.pop();
			TreeNode p2 = path2.pop();
			if (p1 == p2)
				commonP = p1;
			else
				break;
		}
		return commonP;
	}

	// with parent pointer
	// without storage of paths
	public static int getHeight(Node p) {
		int height = 0;
		while (p != null) {
			height++;
			p = p.parent;
		}
		return height;
	}

	// As root->parent is NULL, we don't need to pass root in.
	public static Node lowestCommonAncestor(Node p, Node q) {
		int h1 = getHeight(p);
		int h2 = getHeight(q);
		// swap both nodes in case p is deeper than q.
		if (h1 > h2) {
			int temp = h2;
			h2 = h1;
			h1 = temp;
			Node tempNode = p;
			p = q;
			q = tempNode;
		}
		// invariant: h1 <= h2.
		int dh = h2 - h1;
		for (int h = 0; h < dh; h++)
			q = q.parent;
		while (p != null && q != null) {
			if (p == q)
				return p;
			p = p.parent;
			q = q.parent;
		}
		return null; // p and q are not in the same tree
	}

	// if BST
	public Node query(Node root, Node n1, Node n2) {
		int left;
		int right;
		if (n1.val > n2.val) {
			right = n1.val;
			left = n2.val;
		} else {
			right = n2.val;
			left = n1.val;
		}
		while (root != null) {
			if (root.val < left)
				root = root.right;
			else if (root.val > right)
				root = root.left;
			else if (root.val == left || root.val == right)
				return root;
			else
				// left < root.val < right
				return root;
		}
		return null;
	}
	
	public static Node LCA(Node root, Node p, Node q) {
		if (root == null || p == null || q == null)
			return null;
		if (Math.max(p.val, q.val) < root.val)
			return LCA(root.left, p, q);
		else if (Math.min(p.val, q.val) > root.val)
			return LCA(root.right, p, q);
		else
			return root;
	}

	public class Node {
		int val;
		Node left;
		Node right;
		Node parent;

		Node(int val, Node left, Node right, Node parent) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}

	public class TreeNode {
		int val;
		TreeNode parent;
		ArrayList<TreeNode> childList;

		TreeNode(int x, TreeNode parent, ArrayList<TreeNode> childList) {
			val = x;
			this.parent = parent;
			this.childList = childList;
		}
	}
}
