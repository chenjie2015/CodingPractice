package leetcode_final;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/*
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsII {
	// // Solution 1: Similar to Permutations I, failed on Judge Large
	// public ArrayList<ArrayList<Integer>> res;
	// public ArrayList<Integer> list;
	//
	// public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
	// // Start typing your Java solution below
	// // DO NOT write main() function
	// res = new ArrayList<ArrayList<Integer>>();
	// list = new ArrayList<Integer>();
	// perm(num, 0);
	// return res;
	// }
	//
	// public void perm(int[] num, int cur) {
	// if (cur == num.length) {
	// for (int i = 0; i < num.length; i++)
	// list.add(num[i]);
	// if (!res.contains(list))
	// res.add(list);
	// list = new ArrayList<Integer>();
	// }
	// for (int i = cur; i < num.length; i++) {
	// int temp = num[i];
	// num[i] = num[cur];
	// num[cur] = temp;
	// perm(num, cur + 1);
	// temp = num[i];
	// num[i] = num[cur];
	// num[cur] = temp;
	// }
	// }

	// Solution 2
	/*
	 * 如果只是增加限定条件 if (i + 1 < num.length && num[i] == num[i + 1]) continue;
	 * 需要保证拿出num[i]之后，num[i....length - 1]部分也应该是排好序的，
	 * 考虑到程序后面还要还原数组num，过于繁琐，此算法不适合改进。
	 * 可以参考Jilong大神http://blog.csdn.net/sunjilong/article/details/8259986用此法。
	 * 
	 * 下面方法统计每个数的个数然后依次取出，保证了取出数以后剩下数组中数的顺序。通过了judge large。
	 */
	public ArrayList<ArrayList<Integer>> res;
	public ArrayList<Integer> list;
	public int[] temp;
	public ArrayList<Integer> value;
	public ArrayList<Integer> counter;

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		res = new ArrayList<ArrayList<Integer>>();
		list = new ArrayList<Integer>();
		value = new ArrayList<Integer>();
		counter = new ArrayList<Integer>();
		Arrays.sort(num);
		int val = num[0];
		int count = 1;
		for (int i = 1; i < num.length; i++) {
			if (val == num[i])
				count++;
			else {
				value.add(val);
				counter.add(count);
				val = num[i];
				count = 1;
			}
		}
		value.add(val);
		counter.add(count);
		temp = new int[num.length];
		perm(temp, 0);
		return res;
	}

	public void perm(int[] temp, int cur) {
		if (cur == temp.length) {
			for (int i = 0; i < temp.length; i++)
				list.add(temp[i]);
			res.add(list);
			list = new ArrayList<Integer>();
		} else {
			for (int i = 0; i < value.size(); i++) {
				if (counter.get(i) > 0) {
					counter.set(i, counter.get(i) - 1);
					temp[cur] = value.get(i);
					perm(temp, cur + 1);
					counter.set(i, counter.get(i) + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] num = { 2, 2, 1, 1 };
		PermutationsII test = new PermutationsII();
		test.permuteUnique(num);
	}
}
