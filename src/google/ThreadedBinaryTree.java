package google;

import util.*;

public class ThreadedBinaryTree {
	public ThreadedBinaryTreeNode root;

	public ThreadedBinaryTreeNode pre;

	public void convertToThreaded(ThreadedBinaryTreeNode root) {
		if (root != null) {
			convertToThreaded(root.left);
			if (null == root.left) {
				root.leftIsThread = true;
				root.left = pre;
			}
			if (pre != null && null == pre.right) {
				pre.rightIsThread = true;
				pre.right = root;
			}
			pre = root;
			convertToThreaded(root.right);
		}
	}

	public void inThreadList(ThreadedBinaryTreeNode root) {
		if (root != null) {
			while (root != null && !root.leftIsThread)
				root = root.left;
			do {
				if (root.rightIsThread) {
					root = root.right;
				} else {
					root = root.right;
					while (root != null && !root.leftIsThread) {
						root = root.left;
					}
				}
			} while (root != null);
		}
	}
}
