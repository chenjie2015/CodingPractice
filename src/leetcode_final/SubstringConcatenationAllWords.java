package leetcode_final;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * You are given a string, S, and a list of words, L,
 * that are all of the same length.
 * Find all starting indices of substring(s) in S
 * that is a concatenation of each word in L exactly once
 * and without any intervening characters.
 * 
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringConcatenationAllWords {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		int words_num = L.length;
		if (words_num <= 0)
			return res;
		HashMap<String, Integer> words = new HashMap<String, Integer>();
		HashMap<String, Integer> curString = new HashMap<String, Integer>();
		for (int i = 0; i < words_num; i++) {
			if (words.get(L[i]) != null)
				words.put(L[i], words.get(L[i]) + 1);
			else
				words.put(L[i], 1);
		}
		int len = L[0].length();
		for (int i = 0; i <= S.length() - words_num * len; i++) {
			// i 为S截取部分的起始坐标，末尾不及words_num * len长度的不用比较
			curString.clear();
			for (int j = 0; j < words_num; j++) {
				String cur = S.substring(i + j * len, i + j * len + len);// 截取len长度的词
				if (!words.containsKey(cur))// 比较
					break;
				if (curString.get(cur) != null)// 统计个数
					curString.put(cur, curString.get(cur) + 1);
				else
					curString.put(cur, 1);
				if (curString.get(cur) > words.get(cur))// 超出个数
					break;
				if (j == words_num - 1)// 全部词汇用完
					res.add(i);
			}
		}
		return res;
	}
}
