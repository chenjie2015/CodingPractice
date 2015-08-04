package google;

public class MedianTwoSortedArray {
	public double findKth(int a[], int as, int ae, int b[], int bs, int be,
			int k) {
		// always assume that m is equal or smaller than n
		int aNum = ae - as + 1;
		int bNum = be - bs + 1;
		if (aNum > bNum)
			return findKth(b, bs, be, a, as, ae, k);
		if (aNum == 0 && k - 1 <= bNum)
			return b[k - 1];
		if (k == 1)
			return Math.min(a[0], b[0]);
		// divide k into two parts
		int pa = Math.min(k / 2, aNum), pb = k - pa;
		if (a[pa - 1] < b[pb - 1])
			return findKth(a, as + pa, ae, b, bs, be - pa, k - pa);
		else if (a[pa - 1] > b[pb - 1])
			return findKth(a, as, ae - pb, b, bs + pb, be, k - pb);
		else
			return a[pa - 1];
	}

	public double findMedianSortedArrays(int A[], int m, int B[], int n) {
		int total = m + n;
		if (total % 2 == 1)
			return findKth(A, 0, m, B, 0, n, total / 2 + 1);
		else
			return (findKth(A, 0, m, B, 0, n, total / 2) + findKth(A, 0, m, B,
					0, n, total / 2 + 1)) / 2;
	}

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
}
