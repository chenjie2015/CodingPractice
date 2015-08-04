package leetcode_final;

import java.util.ArrayList;
/*
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */

public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> line;
		if(numRows < 1)
			return res;
		for(int i = 0; i < numRows; i++){
			line = new ArrayList<Integer>();
			for(int j = 0; j <= i; j++){
				if(j == 0)
					line.add(1);
				else if(j == i)
					line.add(1);
				else
					line.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
			}
			res.add(line);
		}
		return res;
	}
}
