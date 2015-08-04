package leetcode.blog;

import util.*;

/*
 * Convert a BST to a sorted circular doubly-linked list in-place.
 * Think of the left and right pointers as synonymous to
 * the previous and next pointers in a doubly-linked list.
 */
public class ConvertBSTToSortedDoublyLinkedList {
	public static TreeNode prev = null;
	public static TreeNode head = null;

	// This is a modified in-order traversal adapted to this problem
	// prev (init to NULL) is used to keep track of previously traversed node
	// head pointer is updated with the list's head as recursion ends
	public static void treeToDoublyList(TreeNode root) {
		if (root == null)
			return;
		treeToDoublyList(root.left);
		// current node's left points to previous node
		root.left = prev;
		if (prev != null)
			prev.right = root; // previous node's right points to current node
		else
			head = root; // current node (smallest element) is head of
							// the list if previous node is not available
		// as soon as the recursion ends, the head's left pointer
		// points to the last node, and the last node's right pointer
		// points to the head pointer.
		TreeNode right = root.right;
		head.left = root;
		root.right = head;
		// updates previous node
		prev = root;
		treeToDoublyList(right);
	}

	// Given an ordered binary tree, returns a sorted circular
	// doubly-linked list. The conversion is done in-place.
	public static TreeNode convertToDoublyList(TreeNode root) {
		treeToDoublyList(root);
		return head;
	}

	public static void main(String[] args) {
		TreeNode root17 = new TreeNode(10);
		root17.left = new TreeNode(5);
		root17.left.left = new TreeNode(1);
		root17.left.right = new TreeNode(8);
		root17.right = new TreeNode(15);
		root17.right.right = new TreeNode(17);
		TreeNode head = ConvertBSTToSortedDoublyLinkedList
				.convertToDoublyList(root17);
		System.out.println();
	}
}
