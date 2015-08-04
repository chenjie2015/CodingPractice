package leetcode_final;

/*
 *  Given an unsorted integer array, find the first missing positive integer.
 *  
 *  For example,
 *  Given [1,2,0] return 3,
 *  and [3,4,-1,1] return 2.
 *  Your algorithm should run in O(n) time and uses constant space. 
 */
public class FirstMissingPositive {

	// 第二次遍历，用第cur - 1位数的正负来表示数cur是否在数组A[]中。负的表示存在cur + 1。
	public int firstMissingPositive(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = A.length;
		if (len < 1)
			return 1;
		for (int i = 0; i < len; i++) {
			if (A[i] < 0)
				A[i] = 0;
		}
		for (int i = 0; i < len; i++) {
			int cur = Math.abs(A[i]);
			if (cur <= len && cur != 0) {
				if (A[cur - 1] > 0)
					A[cur - 1] = -A[cur - 1];
				else if (A[cur - 1] == 0)
					A[cur - 1] = -len - 1;
			}
		}
		int i = 0;
		while (i < len && A[i] < 0)
			i++;
		return i + 1;
	}
}
