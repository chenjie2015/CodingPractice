package leetcode.blog;

public class CheckPowerOf2 {
	/*
	 * Q8 Check whether an integer is a power of two.
	 */
	boolean mystery(int x) {// bug is when x == 0
		return (x & (x - 1)) == 0;
	}

	boolean mysteryZero(int x) {
		return x != 0 && (x & (x - 1)) == 0;
	}
}
