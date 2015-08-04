package leetcode_final;

/*
 * Given an integer n,
 * generate a square matrix filled with elements from 1 to n^2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {
	// 1. Works only for even n. 因为无法处理最后的中心数
	public int[][] generateMatrix(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] res = new int[n][n];
		int max = n * n;
		int counter = 1;
		int layer = 0;
		while (true) {
			for (int i = layer; i < n - layer - 1; i++) {
				res[layer][i] = counter;
				counter++;
			}
			if (counter > max)
				break;
			for (int i = layer; i < n - layer - 1; i++) {
				res[i][n - layer - 1] = counter;
				counter++;
			}
			if (counter > max)
				break;
			for (int i = n - layer - 1; i >= layer + 1; i--) {
				res[n - layer - 1][i] = counter;
				counter++;
			}
			if (counter > max)
				break;
			for (int i = n - layer - 1; i >= layer + 1; i--) {
				res[i][layer] = counter;
				counter++;
			}
			if (counter > max)
				break;
			layer++;
		}
		return res;
	}

	// 2. 稍微处理下边角，通过。
	public int[][] generateMatrix2(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] res = new int[n][n];
		int max = n * n;
		int counter = 1;
		int layer = 0;
		while (true) {
			for (int i = layer; i <= n - layer - 1; i++) {
				res[layer][i] = counter;
				counter++;
			}
			if (counter > max)
				break;
			for (int i = layer + 1; i < n - layer - 1; i++) {
				res[i][n - layer - 1] = counter;
				counter++;
			}
			if (counter > max)
				break;
			for (int i = n - layer - 1; i >= layer; i--) {
				res[n - layer - 1][i] = counter;
				counter++;
			}
			if (counter > max)
				break;
			for (int i = n - layer - 2; i >= layer + 1; i--) {
				res[i][layer] = counter;
				counter++;
			}
			if (counter > max)
				break;
			layer++;
		}
		return res;
	}

	// 3. Better coding style
	public int[][] generateMatrix3(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] res = new int[n][n];
		if (n == 0)
			return res;
		int num = 0;
		int layer = n / 2;
		for (int i = 0; i < layer; ++i) {
			int j;
			for (j = i; j < n - 1 - i; ++j)
				res[i][j] = ++num;
			for (j = i; j < n - 1 - i; ++j)
				res[j][n - 1 - i] = ++num;
			for (j = n - 1 - i; j > i; --j)
				res[n - 1 - i][j] = ++num;
			for (j = n - 1 - i; j > i; --j)
				res[j][i] = ++num;
		}
		if (n % 2 == 1)
			res[n / 2][n / 2] = ++num;
		return res;
	}
}
