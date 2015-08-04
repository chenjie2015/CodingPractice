package leetcode_final;

import java.util.ArrayList;

/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *  [".Q..",  // Solution 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 *  
 *  ["..Q.",  // Solution 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 */
public class NQueens {
	public ArrayList<String[]> res;
	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] place = new int[n];
		// place[i] = j 表示第i行第j列可以放Q
		res = new ArrayList<String[]>();
		placeQueens(0, n, place);
		return res;
	}
	
	// 检测前面行可以放Q的位置是不是和目前位置（place[row]=j）冲突,
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
			String[] matrix = new String[n];
			StringBuilder line;
			for (int i = 0; i < row; i++) {
				line = new StringBuilder("");
				for (int j = 0; j < n; j++) {
					if (j == place[i])
						line.append("Q");
					else
						line.append(".");
				}
				matrix[i] = line.toString();
			}
			res.add(matrix);
			return;
		}
		for (int col = 0; col < n; col++) {
			place[row] = col;
			if (check(row, place))
				placeQueens(row + 1, n, place);
		}
	}
}
