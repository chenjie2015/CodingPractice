package leetcode_final;

/*
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") ? false
 * isMatch("aa","aa") ? true
 * isMatch("aaa","aa") ? false
 * isMatch("aa", "a*") ? true
 * isMatch("aa", ".*") ? true
 * isMatch("ab", ".*") ? true
 * isMatch("aab", "c*a*b") ? true
 */
public class RegularExpressionMatching {
	// 1176ms
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.equals(p))
			return true;
		else if (s.length() == 0 && p.length() == 0)
			return true;
		else if (p.length() == 0) // s.length()!=0
			return false;
		else if (s.length() == 0) {// p.lengt()!=0
			if ((p.length() > 1 && p.charAt(1) != '*') || (p.length() < 2))
				return false;
			else
				return isMatch(s, p.substring(2));// p去掉头两个char: ".*", "a*",
													// "b*".....
		} else if (p.length() > 1 && p.charAt(1) == '*') {
			if (isMatch(s, p.substring(2)))
				return true;
			while (s.length() > 0
					&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(1), p.substring(2)))
					return true;
				s = s.substring(1);
			}
		} else if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')
			return false;
		else
			return isMatch(s.substring(1), p.substring(1));
		return false;
	}

	// 588ms
	// better solution, not using substring, just use index
	public boolean isMatch2(String s, String p) {
		if (s == null)
			return p == null;
		return match2(s, p, 0, 0);
	}

	public boolean match2(String s, String p, int i, int j) {
		if (j == p.length())
			return i == s.length();
		if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
			if (i == s.length())
				return false;
			return (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
					&& match2(s, p, ++i, ++j);
		}
		// j != p.length() -1 && p.charAt(j + 1) == '*'
		while (i < s.length()
				&& (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)))
			if (match2(s, p, i++, j + 2))
				return true;
		return match2(s, p, i, j + 2);
	}

	// Recursive + DP
	// Passed OJ! 480ms
	public boolean isMatch3(String s, String p) {
		if (s == null || p == null)
			return false;
		if (p.length() == 0)
			return s.length() == 0;
		int m = s.length();
		int n = p.length();
		int[][] dp = new int[m + 1][n + 1];
		return isMatch3(s, p, dp, 0, 0) == 1;
	}

	public int isMatch3(String s, String p, int[][] dp, int i, int j) {
		if (dp[i][j] != 0) // s[0, i] p[0, j]
			return dp[i][j];
		else if (i == s.length() && j == p.length())
			return dp[i][j] = 1;
		else if (j == p.length())// i != s.length()
			return dp[i][j] = -1;
		// following
		// i != s.length() && j != p.length()
		// i == s.length() && j != p.length()
		dp[i][j] = -1; // default to false
		if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
			if(i == s.length())
				return dp[i][j] = -1;
			if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
				return dp[i][j] = isMatch3(s, p, dp, i + 1, j + 1);
		} else {// j != p.length() - 1 && p.charAt(j + 1) == '*'
			if (j + 2 <= p.length() && isMatch3(s, p, dp, i, j + 2) == 1)
				return dp[i][j] = 1;
			while (i != s.length()
					&& (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
				if (j + 2 <= p.length() && isMatch3(s, p, dp, i + 1, j + 2) == 1)
					return dp[i][j] = 1;
				++i;
			}
		}
		return dp[i][j];
	}

	// pure DP, bug exists, too complicated, ignore
	public boolean isMatch6(String s, String p) {
		if (s == null || p == null)
			return false;
		int slen = s.length();
		int plen = p.length();
		boolean[][] dp = new boolean[plen + 1][slen + 1];
		dp[0][0] = true;
		for (int i = 1; i <= plen; i++) {
			if (p.charAt(i - 1) == '*') {
				dp[i][0] = i > 1 ? dp[i - 2][0] : false;
				if (i < 2)
					continue;
				if (p.charAt(i - 2) != '.') {
					for (int j = 1; j <= slen; j++) {
						if (dp[i - 1][j]
								|| (i >= 2 && dp[i - 2][j])
								|| (j >= 2 && dp[i][j - 1]
										&& s.charAt(j - 1) == s.charAt(j - 2) && s.charAt(j - 2) == p.charAt(i - 2)))
							dp[i][j] = true;
					}
				} else {
					int j = 1;
					while (!dp[i - 2][j] && j <= slen && !dp[i - 1][j])
						j++;
					for (; j <= slen; j++)
						dp[i][j] = true;
				}
				break;
			} else {
				for (int j = 1; j <= slen; j++) {
					if (dp[i - 1][j - 1]
							&& (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '.'))
						dp[i][j] = true;
				}
				break;
			}
		}
		return dp[plen][slen];
	}

	public static void main(String[] args){
		RegularExpressionMatching test = new RegularExpressionMatching();
		System.out.println(test.isMatch3("aa", "aa"));
	}
}
