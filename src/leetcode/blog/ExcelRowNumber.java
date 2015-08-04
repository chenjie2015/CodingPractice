package leetcode.blog;

public class ExcelRowNumber {
	/*
	 * Q12
	 * Excel sheet row numbers
	 */
	// start from 0
	public static String convert(int row){
		StringBuffer sb = new StringBuffer("");
		sb.append((char)('a' + row % 26));
		row /= 26;
		while(row != 0){
			int index = (row - 1) % 26;
			row = (row - 1) / 26;
			sb.insert(0, (char)(index + 'a'));
		}
		return sb.toString();
	}
	// start from 1
	public static String convert2(int row){
		StringBuffer sb = new StringBuffer("");
		while(row != 0){
			int index = row % 26;
			row /= 26;
			sb.insert(0, (char)(index + 'a' - 1));
		}
		return sb.toString();
	}
}
