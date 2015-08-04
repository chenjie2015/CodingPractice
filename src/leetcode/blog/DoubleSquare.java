package leetcode.blog;

/*
 *     A double-square number is an integer X
 *     which can be expressed as the sum of two perfect squares. 
 *     For example, 10 is a double-square because 10 = 32 + 12.
 *     Your task in this problem is, given X,
 *     determine the number of ways in which
 *     it can be written as the sum of two squares. 
 *     For example, 10 can only be written as 3^2 + 1^2 
 *     (we don’t count 1^2 + 3^2 as being different). 
 *     On the other hand, 25 can be written as 52 + 02 or as 42 + 32.

 Input
 You should first read an integer N, the number of test cases. 
 The next N lines will contain N values of X.

 Constraints
 0 = X = 2147483647
 1 = N = 100

 Output
 For each value of X, you should output the number of ways to write X as the sum of two squares.
 */
public class DoubleSquare {
	public static int doubleSquare(int m) {
		double p = Math.sqrt((double) m / 2.0);
		int total = 0;
		for (int i = 0; i <= p; i++) {
			double j = Math.sqrt((double) m - i * i);
			if (j - (int) j == 0.0) // might have precision issue,
				total++; // can be resolved using |j-(int)j| == delta
		}
		return total;
	}
}
