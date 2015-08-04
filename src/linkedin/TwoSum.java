package linkedin;

import java.util.Arrays;
import java.util.Hashtable;
/*
 * Given an array of integers,
 * find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers
 * such that they add up to the target, where index1 must be less than index2.
 * Please note that your returned answers
 * (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum {
	// Solution 1 O(n)
	public int[] twoSum(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] res = { 0, 0 };
		Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				res[0] = map.get(numbers[i]) + 1;
				res[1] = i + 1;
				return res;
			} else
				map.put(target - numbers[i], i);
		}
		return res;
	}

	// Solution 2 Because of sorting, O(nlgn)
	public int[] twoSum_2(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] res = { 0, 0 };
		// in order to store original indexes
		int[] dup_list = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			dup_list[i] = numbers[i];
		}
		Arrays.sort(numbers);
		int low = 0, high = numbers.length - 1;
		while (low < high) {
			if (numbers[low] + numbers[high] == target) {
				for(int i = 0; i < dup_list.length; i++){
					if(dup_list[i] == numbers[low] && res[0] == 0)
						res[0] = i + 1;
					if(dup_list[i] == numbers[high])
						res[1] = i + 1;
				}
				break;
			} else if (numbers[low] + numbers[high] > target) {
				high--;
			} else
				low++;
		}
		// according to the rule, smaller index in front
		if (res[0] > res[1]) {
			int temp = res[1];
			res[1] = res[0];
			res[0] = temp;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] numbers = { 150, 24, 79, 50, 88, 345, 3 };
		int target = 200;
		TwoSum test = new TwoSum();
		int[] res = new int[2];
		res = test.twoSum_2(numbers, target);
		System.out.println(Arrays.toString(res));
	}
}
