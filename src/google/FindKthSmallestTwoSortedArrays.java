package google;

public class FindKthSmallestTwoSortedArrays {
	// Solution 1 Merge two arrays O(m + n)
	// Solution 2 Search from the beginning O(k)
	// Solution 3 O(lgm + lgn)
	public int findKthSmallest(int A[], int as, int ae, int B[], int bs,
			int be, int k) {
		int aNum = ae - as + 1;
		int bNum = be - bs + 1;
		if (aNum <= 0 || bNum <= 0 || k <= 0 || k > aNum + bNum)
			return -1;
		int i = (int) ((double) aNum / (aNum + bNum) * (k - 1));
		int j = (k - 1) - i;
		if (i < as || j < bs || i > ae || j > be)
			return -1;
		// invariant: i + j = k-1
		// Note: A[-1] = -INF and A[m] = +INF to maintain invariant
		int Ai_1 = ((i == as) ? Integer.MIN_VALUE : A[i - 1]);
		int Bj_1 = ((j == bs) ? Integer.MIN_VALUE : B[j - 1]);
		int Ai = ((i == ae) ? Integer.MAX_VALUE : A[i]);
		int Bj = ((j == be) ? Integer.MAX_VALUE : B[j]);

		if (Bj_1 < Ai && Ai < Bj)
			return Ai;
		else if (Ai_1 < Bj && Bj < Ai)
			return Bj;
		// (Ai > Bj && Ai_1 > Bj) || (Ai < Bj && Ai < Bj_1)
		if (Ai < Bj)
			// exclude Ai and below portion
			// exclude Bj and above portion
			return findKthSmallest(A, as + i + 1, ae, B, bs, j, k - i - 1);
		else
			/* Bj < Ai */
			// exclude Ai and above portion
			// exclude Bj and below portion
			return findKthSmallest(A, as, i, B, bs + j + 1, be, k - j - 1);
	}
	
	public static void main(String[] args){
		int[] A = {};
		int[] B = {};
	}
}
