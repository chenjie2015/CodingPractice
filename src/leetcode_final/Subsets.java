package leetcode_final;

/*
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * 
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If S = [1,2,3], a solution is:
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> set = new ArrayList<Integer>();
		// Remember to sort array S as required by the question.
		Arrays.sort(S);
		subsets(res, set, S, 0);
		return res;
	}

	public void subsets(ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> sets, int[] S, int index) {
		if (index == S.length) {
			res.add(new ArrayList<Integer>(sets));
		} else {
			sets.add(S[index]);
			subsets(res, sets, S, index + 1);// contains current index element
			sets.remove(sets.size() - 1);
			subsets(res, sets, S, index + 1);
			// do not contain current index element
		}
	}
}
