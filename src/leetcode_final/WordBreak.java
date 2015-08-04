package leetcode_final;

import java.util.HashSet;
import java.util.Set;

/*
 *  Given a string s and a dictionary of words dict,
 *  determine if s can be segmented into a space-separated sequence
 *  of one or more dictionary words.
 *  
 *  For example, given
 *  s = "leetcode",
 *  dict = ["leet", "code"].
 *  
 *  Return true because "leetcode" can be segmented as "leet code". 
 */
public class WordBreak {
	// Solution 1. DP matrix.
	public boolean wordBreak(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (s.length() < 1)
			return true;
		if (dict.size() == 0)
			return false;
		// seg[i, j] means substring t starting from i and length is j

		boolean[][] seg = new boolean[s.length()][s.length() + 1];
		for (int len = 1; len <= s.length(); len++) {
			for (int i = 0; i + len <= s.length(); i++) {
				String temp = s.substring(i, i + len);
				if (dict.contains(temp)) {
					seg[i][len] = true;
					continue;
				}
				for (int k = 1; k < len; k++) {
					if (seg[i][k] && seg[i + k][len - k]) {
						seg[i][len] = true;
						break;
					}
				}
			}
		}
		return seg[0][s.length()];
	}

	// Solution 2. Recursive.
	public boolean wordBreak2(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		for (int i = 0; i <= s.length(); i++)
			for (int j = 0; j < i; j++)
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
		return f[s.length()];
	}

	// Further question. One result solution needed.
	public String getSentence(String text, Set<String> dict) {
		int n = text.length();
		int[] dp = new int[n + 1];
		dp[n] = n;
		for (int i = n - 1; i >= 0; i--) {
			int j = i + 1;
			while (j <= n
					&& (!dict.contains(text.substring(i, j)) || dp[j] == 0))
				j++;
			if (j <= n)
				dp[i] = j;
		}
		if (dp[0] == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < n) {
			sb.append(text.substring(i, dp[i]) + " ");
			i = dp[i];
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		WordBreak test = new WordBreak();
		test.wordBreak("ab", dict);
	}
}
