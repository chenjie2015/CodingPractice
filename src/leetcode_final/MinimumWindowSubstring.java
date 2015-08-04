package leetcode_final;
/*
 * Given a string S and a string T,
 * find the minimum window in S
 * which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T,
 * return the emtpy string"".
 * If there are multiple such windows,
 * you are guaranteed that there will always be only one unique minimum window in S.
 * 用hashtable的时候，如果key不存在而取值会报错，多个地方需要检查存在与否，不太合适。不如直接使用int[256]数组来记录。
 */
import java.util.Hashtable;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// goal 统计T中的字母及其个数
		Hashtable<Character, Integer> goal = new Hashtable<Character, Integer>();
		// process 统计过程中字母及其个数
		Hashtable<Character, Integer> process = new Hashtable<Character, Integer>();
		int lenS = S.length();
		int lenT = T.length();
		int sum = lenT;
		for (int i = 0; i < lenT; i++) {
			char cur = T.charAt(i);
			process.put(cur, 0);
			if (!goal.containsKey(cur))
				goal.put(cur, 1);
			else {
				goal.put(cur, goal.get(cur) + 1);
			}
		}
		int begin = 0, end = 0, minWin = S.length() + 1;
		int min_beg = 0, min_end = 0;
		int counter = 0;
		while (end < lenS) {
			char cur = S.charAt(end);
			char beg_char = S.charAt(begin);
			// 如果goal中没有则继续下一个字母
			if (!goal.containsKey(cur) || goal.get(cur) == 0) {
				end++;
				continue;
			}
			// goal中含有此字母cur
			process.put(cur, process.get(cur) + 1);
			// counter记录目前命中几个字母
			if (process.get(cur) <= goal.get(cur))
				counter++;
			if (counter == sum) {
				// 此while loop用来缩小前界限begin
				while (!process.containsKey(beg_char) || process.get(beg_char) > goal.get(beg_char)) {
					if(process.containsKey(beg_char)){
						process.put(beg_char, process.get(beg_char) - 1);
					}
					begin++;
					beg_char = S.charAt(begin);
				}
				int len = end - begin + 1;
				if (len < minWin) {
					minWin = len;
					min_beg = begin;
					min_end = end;
				}
			}
			end++;
		}
		return minWin <= lenS ? S.substring(min_beg, min_end + 1) : "";
	}

	public static void main(String[] args) {
		MinimumWindowSubstring test = new MinimumWindowSubstring();
		System.out.println(test.minWindow("ab", "b"));
	}
}