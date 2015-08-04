package leetcode.blog;

public class SearchYoungTableau {
	// Q13 Search Young Tableau
		// O(n)
		public static boolean stepwise(int[][] table, int target){
			if(table.length == 0)
				return false;
			if(table[0].length == 0)
				return false;
			int row = table.length;
			int col = table[0].length;
			if(target < table[0][0] || target > table[row - 1][col - 1])
				return false;
			for(int i = 0, j = 0; i < row && j >= 0;){
				if(table[i][j] == target)
					return true;
				else if(table[i][j] > target)
					j--;
				else
					i++;
			}
			return false;
		}
		// O(n^1.58)
		// row number ranges from top to bottom, column number ranges from left to right
		public static boolean quadPartition(int[][] table, int target, int left, int top, int right, int bottom){
			if(left > right || top > bottom)
				return false;
			if(target < table[top][left] || target > table[bottom][right])
				return false;
			int col = (right + left) / 2;
			int row = (top + bottom) / 2;
			if(table[row][col] == target)
				return true;
			else if (left == right && top == bottom)
				return false;
			if(table[row][col] > target){// upper left || upper right || bottom left
				return quadPartition(table, target, left, top, col, row) ||
						quadPartition(table, target, col + 1, top, right, row) ||
						quadPartition(table, target, left, row + 1, col, bottom);
			} else { // upper right || bottom right || bottom left
				return quadPartition(table, target, col + 1, top, right, bottom) ||
						quadPartition(table, target, col + 1, row + 1, right, bottom) ||
						quadPartition(table, target, left, row + 1, col, bottom);
			}
		}
		// do search on mid column, and then search on upper right side and bottom left side
		// if two sub-matrices are equal sizes, then O(n)
		public static boolean binaryPartition(int[][] table, int target, int left, int top, int right, int bottom){
			if(left > right || top > bottom)
				return false;
			if(target < table[top][left] || target > table[bottom][right])
				return false;
			int mid = (left + right) / 2;
			int row = top;
			// Could use binary search here which reduce complexity to O(lgn * lgn)
			while(row <= bottom && table[row][mid] <= target){
				if(table[row][mid] == target)
					return true;
				row++;
			}
			// upper right || bottom left
			return binaryPartition(table, target, mid + 1, top, top, row - 1) ||
					binaryPartition(table, target, left, row, mid - 1, bottom);
		}
}
