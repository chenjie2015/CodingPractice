package leetcode_final;

import java.util.Arrays;

/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 *Given n and k, return the kth permutation sequence.
 *Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
	// 1. Based on nextPermutation
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}
		for (int i = 1; i < k; i++) {
			num = nextPermutation(num);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(num[i]);
		return sb.toString();
	}

	public int[] nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = num.length;
		if (len <= 1)
			return null;
		for (int i = len - 1; i > 0; i--) {
			// 从 尾部开始，找到第一个下降的元素
			if (num[i - 1] < num[i]) {
				// 找到被交换的那个数， min value in num[i...len - 1] that > num[i - 1]
				int j = i;
				while (j < len && num[j] > num[i - 1])
					j++;
				j--;
				int tmp = num[j];
				num[j] = num[i - 1];
				num[i - 1] = tmp;
				Arrays.sort(num, i, len);
				return num;
			}
		}
		Arrays.sort(num);
		return num;
	}

	// 2. 找到k的位置，以确定最左端数字。
	public String getPermutation2(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0 || k == 0)
			return "";
		int[] cnt = new int[n + 1];
		cnt[0] = 1;
		for (int i = 1; i <= n; i++) {
			cnt[i] = cnt[i - 1] * i;
		}
		if (k > cnt[n])// cnt[n] means total number of permutations
			return null;
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1;
		return getPermutations(nums, cnt, n, k);
	}

	public String getPermutations(int[] nums, int[] cnt, int n, int k) {
		if (n == 0)
			return "";
		for (int i = 1; i <= n; i++) {
			if (k <= cnt[n - 1] * i) {
				int t = nums[i - 1];
				for (int j = i - 1; j < n - 1; j++) {
					nums[j] = nums[j + 1];
				}
				return Integer.toString(t)
						+ getPermutations(nums, cnt, n - 1, k - cnt[n - 1]
								* (i - 1));
			}
		}
		return "";
	}
}
