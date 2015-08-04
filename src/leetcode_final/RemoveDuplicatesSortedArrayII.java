package leetcode_final;

/*
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesSortedArrayII {
	public int removeDuplicates(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length <= 2)
			return A.length;
		int counter = 0;
		int pos = 0;
		for (int i = 0; i < A.length; i++) {
			if (i == 0 || A[i - 1] != A[i]) {
				counter = 1;
				A[pos++] = A[i];
			} else if (counter == 1) {
				counter++;
				A[pos++] = A[i];
			}
		}
		return pos;
	}
}
