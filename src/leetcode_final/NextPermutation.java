package leetcode_final;

import java.util.Arrays;

/*
 *  Implement next permutation,
 *  which rearranges numbers into the lexicographically
 *  next greater permutation of numbers.
 *  
 *  If such arrangement is not possible,
 *  it must rearrange it as the lowest possible order
 *  (ie, sorted in ascending order).
 *  
 *  The replacement must be in-place, do not allocate extra memory.
 *  
 *  Here are some examples.
 *  Inputs are in the left-hand column
 *  and its corresponding outputs are in the right-hand column.
 *  
 *  1,2,3 → 1,3,2
 *  3,2,1 → 1,2,3
 *  1,1,5 → 1,5,1
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = num.length;
		if (len <= 1)
			return;
		for (int i = len - 1; i > 0; i--) {
			// 找到第一个下降的元素
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
				return;
			}
		}
		Arrays.sort(num);
		return;
	}
}
