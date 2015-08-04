package google;

public class TwoPathMax {
	public int maxPaths(int[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return 0;
		int col = matrix[0].length;
		if (col == 0)
			return 0;
		// Coordinate pair: (r1, c1), (r2, c2)
		// dp[r1][c1][c2] -> r2=r1+c1-c2
		int[][][] dp = new int[row][col][col];
		dp[1][0][1] = matrix[0][1] + matrix[1][0];

		for (int d = 2; d < row + col - 2; ++d) {
			int colLower = Math.max(0, d - row + 1);
			int colUpper = Math.min(d + 1, col);
			for (int c1 = colLower; c1 < colUpper - 1; ++c1) {
				int r1 = d - c1;
				for (int c2 = c1 + 1; c2 < colUpper; ++c2) {
					int r2 = d - c2;
					int best = 0;
					if (r2 > 0) // Up, Up
						best = Math.max(best, dp[r1 - 1][c1][c2]);
					if (c1 > 0) // Left, Left
						best = Math.max(best, dp[r1][c1 - 1][c2 - 1]);
					if (r2 > 0 && c1 > 0) // Left, Up
						best = Math.max(best, dp[r1][c1 - 1][c2]);
					if (c2 - c1 > 1) // Up, Left
						best = Math.max(best, dp[r1 - 1][c1][c2 - 1]);
					dp[r1][c1][c2] = best + matrix[r1][c1] + matrix[r2][c2];
				}
			}
		}
		return dp[row - 1][col - 2][col - 1];
	}
}
