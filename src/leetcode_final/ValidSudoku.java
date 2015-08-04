package leetcode_final;
/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled,
 * where empty cells are filled with the character '.'.
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		// Normal validation solution checking
		// by row, column and square takes O(n^3) time, where n = 9.
		// This solution takes O(n^2) time, but O(n^2) space.
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] table = new int[27][9];
		// 9 for each comparison: row, column, square
		int[][] square = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				if (board[i][j] < '1' || board[i][j] > '9')
					return false;
				int val = board[i][j] - '0';
				if (table[i][val - 1] != 0)
					return false;
				table[i][val - 1] = 1;
				if (table[j + 9][val - 1] != 0)
					return false;
				table[j + 9][val - 1] = 1;
				int squareInt = square[i / 3][j / 3];
				if (table[squareInt + 18][val - 1] != 0)
					return false;
				table[squareInt + 18][val - 1] = 1;
			}
		}
		return true;
	}
}
