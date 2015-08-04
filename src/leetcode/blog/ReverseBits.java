package leetcode.blog;
/*
 * Reverse bits of an unsigned integer.
 */
public class ReverseBits {
	public int swapBits(int x, int i, int j) {
		int lo = ((x >> i) & 1);
		int hi = ((x >> j) & 1);
		int res = lo ^ hi;
		if (res == 1) {
			x ^= ((1 << i) | (1 << j));
		}
		return x;
	}

	public int reverseXor(int x) {
		int n = 32;
		for (int i = 0; i < n / 2; i++)
			x = swapBits(x, i, n - i - 1);
		return x;
	}
}
