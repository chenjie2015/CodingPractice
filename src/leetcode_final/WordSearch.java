package leetcode_final;

/*
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * For example,
 * 
 * Given board =
 * [
 *  ["ABCE"],
 *  ["SFCS"],
 *  ["ADEE"]
 * ]
 * 
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (word.length() < 1)
			return false;
		int row = board.length;
		if (row == 0)
			return false;
		int col = board[0].length;
		if (col == 0)
			return false;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				char cur = word.charAt(0);
				if (board[i][j] == cur) {
					board[i][j] = '$';
					if (find(board, word, 1, i, j))
						return true;
					board[i][j] = cur;
				}
			}
		}
		return false;
	}

	public boolean find(char[][] board, String word, int index, int row, int col) {
		if (index == word.length())
			return true;
		int nRow = board.length;
		int nCol = board[0].length;
		char target = word.charAt(index);
		if (row - 1 >= 0 && board[row - 1][col] == target) {
			board[row - 1][col] = '$';
			if (find(board, word, index + 1, row - 1, col))
				return true;
			board[row - 1][col] = target;
		}
		if (col + 1 < nCol && board[row][col + 1] == target) {
			board[row][col + 1] = '$';
			if (find(board, word, index + 1, row, col + 1))
				return true;
			board[row][col + 1] = target;
		}
		if (row + 1 < nRow && board[row + 1][col] == target) {
			board[row + 1][col] = '$';
			if (find(board, word, index + 1, row + 1, col))
				return true;
			board[row + 1][col] = target;
		}
		if (col - 1 >= 0 && board[row][col - 1] == target) {
			board[row][col - 1] = '$';
			if (find(board, word, index + 1, row, col - 1))
				return true;
			board[row][col - 1] = target;
		}
		return false;
	}
}
