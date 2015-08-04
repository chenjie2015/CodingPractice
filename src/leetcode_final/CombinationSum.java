package leetcode_final;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/*
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ... ak) must be in non-descending order.
 * (ie, a1 <= a2 <= ... <= ak).
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class CombinationSum {
	// DFS solution
	public ArrayList<Integer> cur;
	public ArrayList<ArrayList<Integer>> res;

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
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
		if (target == 0)
			res.add(new ArrayList<Integer>(cur));
		else {
			for (int i = index; i < candidates.length; i++) {
				if (target >= candidates[i]) {
					cur.add(candidates[i]);
					find(candidates, i, cur, target - candidates[i]);
					cur.remove(cur.size() - 1);
				}
			}
		}
	}

	// DP solution: sum(target) = {sum(target-a[i]), a[i]}
	// Hashtable里存放<target, solution>
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(candidates);
		Hashtable<Integer, ArrayList<ArrayList<Integer>>> sum = new Hashtable<Integer, ArrayList<ArrayList<Integer>>>();
		for (int i = 1; i <= target; i++) {
			sum.put(i, new ArrayList<ArrayList<Integer>>());
			int size = candidates.length;
			for (int j = 0; j < size; j++) {
				if (i < candidates[j])
					continue;
				else if (i == candidates[j]) {
					ArrayList<Integer> x = new ArrayList<Integer>();
					x.add(i);
					sum.get(i).add(x);
					continue;
				} else {
					int temp = i - candidates[j];
					for (int k = 0; k < sum.get(temp).size(); k++) {
						ArrayList<Integer> res = new ArrayList<Integer>(sum
								.get(temp).get(k));
						if (res.get(res.size() - 1) <= candidates[j]) {
							res.add(candidates[j]);
							sum.get(i).add(res);
						}
					}
				}
			}
		}
		return sum.get(target);
	}
}
