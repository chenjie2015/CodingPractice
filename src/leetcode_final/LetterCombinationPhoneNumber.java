package leetcode_final;

import java.util.ArrayList;

/*
 * Given a digit string,
 * return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 */
public class LetterCombinationPhoneNumber {
	ArrayList<String> res = null;

	public ArrayList<String> letterCombinations(String digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		res = new ArrayList<String>();
		get_comb(digits, new StringBuilder(""), 0);
		return res;
	}

	public void get_comb(String digits, StringBuilder s, int pos) {
		String[] letters = { "0", "1", "abc", "def", "ghi", "jkl", "mno",
				"pqrs", "tuv", "wxyz" };
		int len = digits.length();
		StringBuilder temp = null;
		if (pos == len) {
			res.add(s.toString());
			return;
		}
		int num = digits.charAt(pos) - '0';
		for (int i = 0; i < letters[num].length(); i++) {
			temp = new StringBuilder(s);
			temp.append(letters[num].charAt(i));
			get_comb(digits, temp, pos + 1);
		}
	}
}
