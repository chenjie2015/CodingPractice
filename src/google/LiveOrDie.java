package google;

public class LiveOrDie {
	public static void update(int[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return;
		int col = matrix[0].length;
		if (col == 0)
			return;
		int[] pre = new int[col];
		int leftCell = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int neighbor = getNeighbor(matrix, pre, leftCell, i, j);
				pre[j] = matrix[i][j];
				leftCell = matrix[i][j];
				if (neighbor < 2)
					matrix[i][j] = 0;
				else if (neighbor > 2)
					matrix[i][j] = 1;
			}
		}
	}

	public static int getNeighbor(int[][] matrix, int[] pre, int leftCell,
			int i, int j) {
		int res = 0;
		if (i - 1 >= 0 && pre[j] == 1)
			res++;
		if (i + 1 < matrix.length && matrix[i + 1][j] == 1)
			res++;
		if (j - 1 >= 0 && leftCell == 1)
			res++;
		if (matrix.length > 0 && j + 1 < matrix[0].length
				&& matrix[i][j + 1] == 1)
			res++;
		return res;
	}
}
