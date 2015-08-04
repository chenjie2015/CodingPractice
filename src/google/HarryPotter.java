package google;

public class HarryPotter {
	public static int findMinPower(int[][] matrix){
		int row = matrix.length;
		if(row == 0)
			return -1;
		int col = matrix[0].length;
		if(col == 0)
			return -1;
		int[][] power = new int[row][col];
		for(int j = col - 2; j >= 0; j--)
			power[row - 1][j] = Math.max(power[row - 1][j + 1] - matrix[row - 1][j], 0);
		for(int i = row - 2; i >= 0; i--)
			power[i][col - 1] = Math.max(power[i + 1][col - 1] - matrix[i][col - 1], 0);
		for(int j = col - 2; j >= 0; j--){
			for(int i = row - 2; i >= 0; i--){
				power[i][j] = Math.min(
						Math.max(power[i + 1][j]- matrix[i][j], 0),
						Math.max(power[i][j + 1]- matrix[i][j], 0));
			}
		}
		return power[0][0];
	}
	public static void main(String[] args){
		int[][] matrix = {{0, -3, 10, -99},
						{-1, -99, 0, -99},
						{1, 0, 0, -6},
						{-99, -99, -99, 0}};
		System.out.println(findMinPower(matrix));
	}

}
