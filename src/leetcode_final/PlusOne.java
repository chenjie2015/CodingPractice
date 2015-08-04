package leetcode_final;

/*
 * Given a number represented as an array of digits, plus one to the number.
 */
import java.util.ArrayList;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = carry + digits[i];
			res.add(sum % 10);
			carry = sum / 10;
		}
		if (carry != 0) {
			res.add(carry);
		}
		int[] result = new int[res.size()];
		for (int i = 0; i < res.size(); i++)
			result[i] = res.get(res.size() - 1 - i);
		return result;
	}
}
