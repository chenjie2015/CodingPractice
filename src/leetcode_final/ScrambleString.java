package leetcode_final;

import java.util.Arrays;

/*
 * Given a string s1,
 * we may represent it as a binary tree
 * by partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":

 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
 / \
 a   t

 * To scramble the string,
 * we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children,
 * it produces a scrambled string"rgeat".

 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
 / \
 a   t

 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" and"at",
 * it produces a scrambled string"rgtae".

 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
 / \
 t   a

 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length,
 * determine if s2 is a scrambled string ofs1.
 */
public class ScrambleString {
	// Brute force. 不剪枝无法通过大集合。通过排序s1和s2来比较，来剪枝一部分，可以通过大集合。
	public boolean isScramble(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;
		char[] s1_char = s1.toCharArray();
		char[] s2_char = s2.toCharArray();
		Arrays.sort(s1_char);
		Arrays.sort(s2_char);
		if (!new String(s1_char).equals(new String(s2_char)))
			return false;
		for (int i = 1; i < s1.length(); i++) {
			String sub1a = s1.substring(0, i);
			String sub1b = s1.substring(i);
			String sub2a = s2.substring(0, i);
			String sub2b = s2.substring(i);
			if (isScramble(sub1a, sub2a) && isScramble(sub1b, sub2b))
				return true;
			sub2a = s2.substring(s2.length() - i);
			sub2b = s2.substring(0, s2.length() - i);
			if (isScramble(sub1a, sub2a) && isScramble(sub1b, sub2b))
				return true;
		}
		return false;
	}

	/*
	 * 3D-DP. dp[i][j][k] 代表了s1从i开始，s2从j开始，长度为k的两个substring是否为scramblestring。
	 * 有三种情况需要考虑： 1. 如果两个substring相等的话，则为true 2.
	 * 如果两个substring中间某一个点，左边的substrings为scramble string
	 * 同时右边的substrings也为scramble string，则为true 3.
	 * 如果两个substring中间某一个点，s1左边的substring和s2右边的substring为scramblestring,
	 * 同时s1右边substring和s2左边的substring也为scramblestring，则为true
	 */
	public boolean isScramble2(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = s1.length();
		boolean[][][] dp = new boolean[n][n][n + 1];
		for (int i = n - 1; i >= 0; i--)
			for (int j = n - 1; j >= 0; j--)
				for (int k = 1; k <= n - Math.max(i, j); k++) {
					if (s1.substring(i, i + k).equals(s2.substring(j, j + k)))
						dp[i][j][k] = true;
					else {
						for (int l = 1; l < k; l++) {
							if (dp[i][j][l] && dp[i + l][j + l][k - l]
									|| dp[i][j + k - l][l]
									&& dp[i + l][j][k - l]) {
								dp[i][j][k] = true;
								break;
							}
						}
					}
				}
		return dp[0][0][n];
	}
}
