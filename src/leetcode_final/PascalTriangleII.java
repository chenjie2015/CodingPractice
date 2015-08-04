package leetcode_final;
/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
import java.util.ArrayList;

public class PascalTriangleII {
	// 其实就是在逐行求数
	// 试验过通向公式，可能因为涉及乘除法，速度不如逐步加法
	public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] res = new int[rowIndex + 1];
		res[0] = 1;
		for(int i = 0; i < rowIndex; i++){
			for(int j = i; j > 0; j--){
				if(j == i)
					res[j] = 1;
				else
					res[j] = res[j - 1] + res[j];
			}
		}
		ArrayList<Integer> res_list = new ArrayList<Integer>();
		for(int i = 0; i < res.length; i++)
			res_list.add(res[i]);
		return res_list;
	}
}
