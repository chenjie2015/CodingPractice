package leetcode.blog;

public class NumberOfOneBits {
	/*
	 * Q9 Number of 1 bits
	 */
	public static int countOneBitsCommon(int x) {
		int counter = 0;
		while ((x & 0x1) != 0) {
			counter++;
			x = x >> 1;
		}
		return counter;
	}

	public static int countOneBits(int x) {
		int counter = 0;
		while (x != 0) {
			counter++;
			x = x & (x - 1);
		}
		return counter;
	}

}
