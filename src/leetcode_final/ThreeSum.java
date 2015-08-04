package leetcode_final;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array S of n integers,
 * are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
 * The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0)
			return res;
		ArrayList<Integer> inner;
		Arrays.sort(num);
		int origin, left, right, sum;
		for (int i = 0; i < num.length - 2;) {// no need for i++ here
			origin = num[i];
			left = i + 1;
			right = num.length - 1;
			while (left < right) {
				sum = origin + num[left] + num[right];
				if (sum == 0) {
					inner = new ArrayList<Integer>();
					inner.add(origin);
					inner.add(num[left]);
					inner.add(num[right]);
					res.add(inner);
					int temp = num[left];
					while (left < right && temp == num[left])
						// skip same number
						left++;
					temp = num[right];
					while (left < right && temp == num[right])
						// skip same number
						right--;
				} else if (sum > 0) {
					right--;
				} else
					left++;
			}
			while (++i < num.length && num[i] == origin)
				;// skip same origins
		}
		return res;
	}
}
