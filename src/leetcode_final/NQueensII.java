package leetcode_final;
/*
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations,
 * return the total number of distinct solutions.
 */
public class NQueensII {
	public int counter;
	public int totalNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] place = new int[n];
		// place[i] = j 表示第i行第j列可以放Q
		counter = 0;
		placeQueens(0, n, place);
		return counter;
	}
	// 检测前面行可以放Q的位置是不是和目前位置（place[row]=j）冲突
	// 即位置[i][place[i]]和位置[row][j]是否冲突
	public boolean check(int row, int[] place) {
		for (int i = 0; i < row; ++i) {
			int diff = Math.abs(place[i] - place[row]);
			if (diff == 0 || diff == row - i)
				return false;
		}
		return true;
	}

	public void placeQueens(int row, int n, int[] place) {
		if (row == n) {
			counter++;
			return;
		}
		for (int col = 0; col < n; col++) {
			place[row] = col;
			if (check(row, place))
				placeQueens(row + 1, n, place);
		}
	}
}
