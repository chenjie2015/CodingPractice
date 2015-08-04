package leetcode_final;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ... ak) must be in non-descending order.
 * (ie, a1 <= a2 <= ... <= ak).
 * 
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class CombinationSumII {
	public ArrayList<Integer> cur;
	public ArrayList<ArrayList<Integer>> res;

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		res = new ArrayList<ArrayList<Integer>>();
		cur = new ArrayList<Integer>();
		Arrays.sort(candidates);
		find(candidates, 0, cur, target);
		return res;
	}

	public void find(int[] candidates, int index, ArrayList<Integer> cur,
			int target) {
		if (target == 0 && !res.contains(cur)) {// difference from Combination
												// Sum I
			res.add(new ArrayList<Integer>(cur));
		} else {
			for (int i = index; i < candidates.length; i++) {
				if (target >= candidates[i]) {
					cur.add(candidates[i]);
					find(candidates, i + 1, cur, target - candidates[i]);// and
																			// here
					cur.remove(cur.size() - 1);
				}
			}
		}
	}
	
	// Solution 2 using DP
	// If using DP, I have to count the number of each integers. Too much work.
}
