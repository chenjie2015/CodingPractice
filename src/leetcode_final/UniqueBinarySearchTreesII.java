package leetcode_final;

/*
 * Given n, generate all structurally unique BST's (binary search trees)
 *  that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */
import java.util.ArrayList;

public class UniqueBinarySearchTreesII {
	public ArrayList<TreeNode> generateTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		generate(res, 1, n);
		return res;
	}

	public void generate(ArrayList<TreeNode> res, int start, int end) {
		if (start > end) {
			res.add(null);// reason of adding NULL is because OJ uses this
							// format to store trees
			return;
		}
		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> left = new ArrayList<TreeNode>();
			ArrayList<TreeNode> right = new ArrayList<TreeNode>();
			generate(left, start, i - 1);
			generate(right, i + 1, end);
			// i is current tree node, left stores left child node, right stores
			// right child node
			// all nodes in left is smaller than i, all nodes in right is larger
			// than i
			// if n == 2;
			// 1st iteration: left null, right 2;
			// 2nd iteration: left 1, right null;
			for (int j = 0; j < left.size(); j++) {
				for (int k = 0; k < right.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = left.get(j);
					root.right = right.get(k);
					res.add(root);
				}
			}
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
	
	public static void main(String[] args){
		UniqueBinarySearchTreesII test = new UniqueBinarySearchTreesII();
		test.generateTrees(2);
	}
}
