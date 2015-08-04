package leetcode_final;

/*
 * Given a collection of integers that might contain duplicates, S,
 * return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetII {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res.add(new ArrayList<Integer>());
		Arrays.sort(num);
		int start = 0;
		for (int i = 0; i < num.length; i++) {
			int size = res.size();
			for (int j = start; j < size; j++) {
				ArrayList<Integer> sub = new ArrayList<Integer>(res.get(j));
				sub.add(num[i]);
				res.add(sub);
			}
			if (i < num.length - 1 && num[i + 1] == num[i])
				start = size;
			else
				start = 0;
		}
		return res;
	}
	/*
	 * For [1, 2, 3], order:
	 * []
	 * [1]
	 * [2] [1, 2]
	 * [3] [1, 3] [2, 3] [1, 2, 3]
	 * For [1, 2, 2], order:
	 * []
	 * [1]
	 * [2] [1, 2]
	 * (start = size) [2, 2] [1, 2, 2]
	 */

	public ArrayList<ArrayList<Integer>> subsetsWithDup2(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ret = new ArrayList<ArrayList<Integer>>();
		cur = new ArrayList<Integer>();
		Arrays.sort(num);
		DFS(num, 0);
		return ret;
	}

	ArrayList<ArrayList<Integer>> ret;
	ArrayList<Integer> cur;

	public void DFS(int[] num, int n) {
		if (num.length == n) {
			ret.add(new ArrayList<Integer>(cur));
			return;
		}
		int count = 1;
		while (n + 1 < num.length && num[n] == num[n + 1]) {
			count++;
			n++;
		}
		for (int i = 0; i <= count; i++) {
			for (int j = 0; j < i; j++)
				cur.add(num[n]);
			DFS(num, n + 1);
			for (int j = 0; j < i; j++)
				cur.remove(cur.size() - 1);
		}
	}
	
	/*
	 * For [1, 2, 3],
	 * order: [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
	 */

	public static void main(String[] args) {
		int[] num = { 1, 2, 3 };
		SubsetII test = new SubsetII();
		test.subsetsWithDup2(num);
	}
}
