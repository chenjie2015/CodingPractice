package leetcode_final;

import java.util.ArrayList;

/*
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations {
	public ArrayList<ArrayList<Integer>> res;
	public ArrayList<Integer> list;

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		res = new ArrayList<ArrayList<Integer>>();
		list = new ArrayList<Integer>();
		perm(num, 0);
		return res;
	}

	public void perm(int[] num, int cur) {
		if (cur == num.length) {
			for (int i = 0; i < num.length; i++)
				list.add(num[i]);
			res.add(list);
			list = new ArrayList<Integer>();
		}
		for (int i = cur; i < num.length; i++) {
			int temp = num[i];
			num[i] = num[cur];
			num[cur] = temp;
			perm(num, cur + 1);
			temp = num[i];
			num[i] = num[cur];
			num[cur] = temp;
		}
	}
	
	public static void main(String[] args){
		Permutations test = new Permutations();
		ArrayList<ArrayList<Integer>> res = test.permute(new int[]{1, 2, 3});
		for(int i = 0; i < res.size(); i++){
			ArrayList<Integer> in = res.get(i);
			for(int j = 0; j < in.size(); j++){
				System.out.print(in.get(j));
			}
			System.out.println();
		}
	}
}
