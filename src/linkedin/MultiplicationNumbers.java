package linkedin;

import java.util.Arrays;

public class MultiplicationNumbers {
	// Q5 Multiplication of Numbers
	/*
	 * There is an array A[N] of N numbers. You have to compose an array
	 * Output[N] such that Output[i] will be equal to multiplication of all the
	 * elements of A[N] except A[i]. Solve it without division operator and in
	 * O(n). For example Output[0] will be multiplication of A[1] to A[N-1] and
	 * Output[1] will be multiplication of A[0] and from A[2] to A[N-1].
	 * Example: A: {4, 3, 2, 1, 2} OUTPUT: {12, 16, 24, 48, 24}
	 */
	public static int[] multiplyNumbers(int[] num) {
		int n = num.length;
		int[] output = new int[n];
		if (n == 0)
			return output;
		Arrays.fill(output, 1);
		int left = 1, right = 1;
		for (int i = 0; i < n; i++) {
			output[i] *= left;
			output[n - i - 1] *= right;
			left *= num[i];
			right *= num[n - 1 - i];
		}
		return output;
	}
}
