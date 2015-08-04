package leetcode_final;

/*
 * Given n non-negative integers representing an elevation map
 * where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * 
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TappingRainWater {
	
	// 每次移动left和right里面小的向中间出发，才能保证另一侧有closure，移动wall注意不能超过另一侧
	// O(N)
	public int trap(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = A.length;
		if (len < 3)
			return 0;
		int left = 0, right = len - 1, res = 0;
		int wall;
		while (left < right) {
			if (A[left] <= A[right]) {
				wall = left + 1;
				while (A[wall] <= A[left] && wall < right) {
					res += A[left] - A[wall];
					wall++;
				}
				left = wall;
			} else { // A[left] > A[right]
				wall = right - 1;
				while (A[wall] <= A[right] && wall > left) {
					res += A[right] - A[wall];
					wall--;
				}
				right = wall;
			}
		}
		return res;
	}
}
