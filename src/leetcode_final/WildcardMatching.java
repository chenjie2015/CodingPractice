package leetcode_final;

import java.util.ArrayList;

/*
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") ? false
 * isMatch("aa","aa") ? true
 * isMatch("aaa","aa") ? false
 * isMatch("aa", "*") ? true
 * isMatch("aa", "a*") ? true
 * isMatch("ab", "?*") ? true
 * isMatch("aab", "c*a*b") ? false
 */
public class WildcardMatching {

	// Recursive solution. Cannot pass Judge Large.
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (p.length() == 0) {
			return s.length() == 0;
		}
		if (p.charAt(0) != '*') {
			if (s.length() != 0
					&& (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?')) {
				return isMatch(s.substring(1), p.substring(1));
			} else {
				return false;
			}
		}
		// p.charAt(0) == '*'
		while (s.length() != 0) {
			while (p.length() > 1 && p.charAt(1) == '*') {
				p = p.substring(1);
			}
			// p.charAt(1) != '*'
			if (isMatch(s, p.substring(1))) {
				return true;
			}
			s = s.substring(1);
		}
		return isMatch(s, p.substring(1));
	}

	// Recursive solution. Use index instead of substring.
	// OJ TLE. Simple test cases passed below in main function.
	public boolean isMatch22(String s, String p) {
		if (s == null || p == null)
			return false;
		return isMatch4(s, p, 0, 0);
	}

	public boolean isMatch4(String s, String p, int i, int j) {
		if (p.length() == j)
			return s.length() == i;
		if (p.charAt(j) != '*') {
			if (s.length() != i
					&& (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?'))
				return isMatch4(s, p, i + 1, j + 1);
			else
				return false;
		}
		// p.charAt(j) == '*'
		while (s.length() != i) {
			while (p.length() > j + 1 && p.charAt(j + 1) == '*')
				j++;
			// p.charAt(j + 1) != '*'
			if (isMatch4(s, p, i, j + 1))
				return true;
			i++;
		}
		return isMatch4(s, p, i, j + 1);
	}

	// Recursive and DP
	// OJ TLE. Simple test cases passed below in main function.
	public boolean isMatch5(String s, String p) {
		if (s == null || p == null)
			return false;
		int m = s.length();
		int n = p.length();
		int[][] dp = new int[m + 1][n + 1];
		return isMatch6(s, p, dp, 0, 0) == 1;
	}

	public int isMatch6(String s, String p, int[][] dp, int i, int j) {
		if (dp[i][j] != 0)
			return dp[i][j];
		else if (s.length() == i && p.length() == j)
			return dp[i][j] = 1;
		else if (p.length() == j) // s.length() != i
			return dp[i][j] = -1;
		dp[i][j] = -1; // default to false
		if (p.charAt(j) != '*') {
			if (s.length() != i
					&& (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?'))
				return dp[i][j] = isMatch6(s, p, dp, i + 1, j + 1);
			else
				return dp[i][j] = -1;
		}
		// p.charAt(j) == '*'
		while (s.length() != i) {
			while (p.length() > j + 1 && p.charAt(j + 1) == '*')
				j++;
			// p.charAt(j + 1) != '*'
			if (isMatch6(s, p, dp, i, j + 1) == 1)
				return dp[i][j] = 1;
			i++;
		}
		return dp[i][j] = isMatch6(s, p, dp, i, j + 1);
	}

	// Non-recursive. Bug exists.
	public boolean isMatch2(String s, String p) {
		// Start typing your JAVA solution below
		// DO NOT write main() function
		boolean star = false;
		int i = 0, j = 0;
		// i for str index, j for pat index
		while (i < s.length() && j < p.length()) {
			if (p.charAt(j) == '?' && star == false) {
				i++;
				j++;
			} else if (p.charAt(j) == '*') {
				star = true;
				do {
					j++;
				} while (j < p.length() && p.charAt(j) == '*');
				if (j == p.length()) // p has '*' ending
					return true;
			} else {
				if (s.charAt(i) != p.charAt(j)) {
					if (!star)// p has no '*' in previous position
						return false;
					i++;// s moves to next char
				} else {
					// s and p both move to next char
					i++;
					j++;
				}
			}
		}
		while (j < p.length() && p.charAt(j) == '*')
			j++;
		return (j == p.length() && i == s.length());
	}

	// Non-recursive solution. 764 ms
	public boolean isMatch31(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (p.length() == 0)
			return s.length() == 0;
		int i = 0;
		int j = 0;
		int star = -1;
		int back = -1;
		while (i < s.length()) {
			if (j < p.length()
					&& (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
				i++;
				j++;
			} else if (j < p.length() && p.charAt(j) == '*') {
				back = i;
				star = j;
				j++;
			} else {
				if (star != -1) {
					i = back + 1;
					j = star + 1;
					back = i;
				} else {
					return false;
				}
			}
		}
		while (j < p.length() && p.charAt(j) == '*')
			j++;
		return j == p.length();
	}

	// Pure DP. OJ TLE.
	public boolean isMatch66(String s, String p) {
		char[] cs = s.toCharArray();
		char[] cp = p.toCharArray();
		int lens = cs.length;
		int lenp = cp.length;
		boolean[][] match = new boolean[lens + 1][lenp + 1];
		match[0][0] = true;

		char a, b;
		for (int i = 0; i <= lens; i++) {
			for (int j = 0; j <= lenp; j++) {
				if (j > 0) {
					b = cp[j - 1];
					match[i][j] |= match[i][j - 1] && b == '*';
					if (i > 0) {
						a = cs[i - 1];
						match[i][j] |= match[i - 1][j] && b == '*';
						match[i][j] |= match[i - 1][j - 1] && charMatch(a, b);
					}
				}
			}
		}
		return match[lens][lenp];
	}

	private boolean charMatch(char a, char b) {
		return a == b || b == '?' || b == '*';
	}

	// Pure DP. Convert from c++, bug exists.
	public boolean isMatch77(String s, String p) {
		int n = s.length(), m = p.length(), i, j, chars = 0;
		for (i = 0; i < p.length(); ++i)
			if (p.charAt(i) != '*' && n < ++chars)
				return false;
		boolean[] dp = new boolean[n + 2];
		for (i = m - 1, dp[n] = true; i >= 0; --i) {
			if (p.charAt(i) == '*') {
				while (i > 0 && p.charAt(i) == p.charAt(i - 1))
					--i; // skip multiple *
				for (j = n; j >= 0 && !dp[j]; --j)
					;
				for (; j >= 0; --j)
					dp[j] = true;
			} else {
				for (j = 0; j < n + 1; ++j)
					dp[j] = (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') ? dp[j + 1]
							: false;
			}
		}
		return dp[0];
	}

	// Greedy solutions. Split p by '*' or multiple '*'
	// too much details to consider. 752ms
	public int matchSub(String s, String p, int start, int end) {
		int j = start;
		for(; j <= end + 1 - p.length(); j++) {
			if(s.charAt(j) == p.charAt(0) || p.charAt(0) == '?'){
				int pos = j + 1;// start from next index
				for(int i = 1; i < p.length(); i++, pos++){
					if(pos > end)
						return -1;
					if(s.charAt(pos) != p.charAt(i) && p.charAt(i) != '?')
						break;
				}
				if(pos - j == p.length()) // all p has been matched
					return pos;
			}
		}
		return -1; // fall out of loop, no matching
	}

	public ArrayList<String> splitPattern(String p, int start, int end) {
		ArrayList<String> splitp = new ArrayList<String>();
		StringBuilder seg = new StringBuilder("");
		for (int i = start; i <= end; i++) {
			char c = p.charAt(i);
			if (c == '*') {
				if (seg.length() > 0) {
					splitp.add(seg.toString());
					seg = new StringBuilder("");
				}
			} else
				seg.append(c);
		}
		return splitp;
	}

	public boolean isMatch8(String s, String p) {
		if (s == null || p == null)
			return false;
		if (p.length() == 0)
			return s.length() == 0;
		// deal with start and end portion of p
		int sStartIndex = 0, sEndIndex = s.length() - 1;
		int pStartIndex = 0, pEndIndex = p.length() - 1;
		// if p starts with no '*', all start part has to be matched to s
		if(p.charAt(0) != '*'){
			for(; pStartIndex < p.length() && p.charAt(pStartIndex) != '*';
					pStartIndex++, sStartIndex++){
				if(sStartIndex >= s.length()
						|| (s.charAt(sStartIndex) != p.charAt(pStartIndex)
						&& p.charAt(pStartIndex) != '?'))
					return false;
			}
			if(pStartIndex == p.length() && sStartIndex < s.length())
				return false;
		}
		// s and p has been matched completely
		if(pStartIndex == p.length() && sStartIndex == s.length())
			return true;
		// same with tail part
		if(p.charAt(p.length() - 1) != '*'){
			for(; pEndIndex >= 0 && p.charAt(pEndIndex) != '*';
					pEndIndex--, sEndIndex--){
				if(sEndIndex < 0
						|| (s.charAt(sEndIndex) != p.charAt(pEndIndex)
						&& p.charAt(pEndIndex) != '?'))
					return false;
			}
			if(pEndIndex == -1 && sEndIndex >= 0)
				return false;
		}
		// deal with cases like s = "aba" p = "abaaba"
		if(sStartIndex - sEndIndex > 1)
			return false;
		ArrayList<String> splitp = splitPattern(p, pStartIndex, pEndIndex);
		if (splitp.size() == 0) // all '*' in p
			return true;
		for (int i = 0; i < splitp.size(); ++i) {
			String pSub = splitp.get(i);
			sStartIndex = matchSub(s, pSub, sStartIndex, sEndIndex);
			if(sStartIndex == -1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		WildcardMatching test = new WildcardMatching();
		// test.isMatch31("abcdefg", "abc*?fg");
		// System.out.println(test.isMatch22("aa", "a") + " = false");
		// System.out.println(test.isMatch22("aa", "aa") + " = true");
		// System.out.println(test.isMatch22("aaa", "aa") + " = false");
		// System.out.println(test.isMatch22("aa", "*") + " = true");
		// System.out.println(test.isMatch22("aa", "a*") + " = true");
		// System.out.println(test.isMatch22("ab", "?*") + " = true");
		// System.out.println(test.isMatch22("aa", "c*a*b*") + " = false");
		// System.out.println(test.isMatch22("abce", "abc*?") + " = true");
		// System.out.println(test.isMatch22("abce", "abc*??") + " = false");
		// System.out.println(test.isMatch22("abcde", "abc*?") + " = true");
		// System.out.println(test.isMatch22("abc", "*?*?*?*?") + " = false");
		// System.out.println(test.isMatch22("abcd", "*?*?*?*?") + " = true");
		//
		// System.out.println("*****************");
		// System.out.println(test.isMatch("aa", "a") + " = false");
		// System.out.println(test.isMatch("aa", "aa") + " = true");
		// System.out.println(test.isMatch("aaa", "aa") + " = false");
		// System.out.println(test.isMatch("aa", "*") + " = true");
		// System.out.println(test.isMatch("aa", "a*") + " = true");
		// System.out.println(test.isMatch("ab", "?*") + " = true");
		// System.out.println(test.isMatch("aa", "c*a*b*") + " = false");
		// System.out.println(test.isMatch("abce", "abc*?") + " = true");
		// System.out.println(test.isMatch("abce", "abc*??") + " = false");
		// System.out.println(test.isMatch("abcde", "abc*?") + " = true");
		// System.out.println(test.isMatch("abc", "*?*?*?*?") + " = false");
		// System.out.println(test.isMatch("abcd", "*?*?*?*?") + " = true");
		//
		// System.out.println("*****************");
		// System.out.println(test.isMatch5("aa", "a") + " = false");
		// System.out.println(test.isMatch5("aa", "aa") + " = true");
		// System.out.println(test.isMatch5("aaa", "aa") + " = false");
		// System.out.println(test.isMatch5("aa", "*") + " = true");
		// System.out.println(test.isMatch5("aa", "a*") + " = true");
		// System.out.println(test.isMatch5("ab", "?*") + " = true");
		// System.out.println(test.isMatch5("aa", "c*a*b*") + " = false");
		// System.out.println(test.isMatch5("abce", "abc*?") + " = true");
		// System.out.println(test.isMatch5("abce", "abc*??") + " = false");
		// System.out.println(test.isMatch5("abcde", "abc*?") + " = true");
		// System.out.println(test.isMatch5("abc", "*?*?*?*?") + " = false");
		// System.out.println(test.isMatch5("abcd", "*?*?*?*?") + " = true");
		//
//		System.out.println("*****************");
//		System.out.println(test.isMatch66("aa", "a") + " = false");
//		System.out.println(test.isMatch66("aa", "aa") + " = true");
//		System.out.println(test.isMatch66("aaa", "aa") + " = false");
//		System.out.println(test.isMatch66("aa", "*") + " = true");
//		System.out.println(test.isMatch66("aa", "a*") + " = true");
//		System.out.println(test.isMatch66("ab", "?*") + " = true");
//		System.out.println(test.isMatch66("aa", "c*a*b*") + " = false");
//		System.out.println(test.isMatch66("abce", "abc*?") + " = true");
//		System.out.println(test.isMatch66("abce", "abc*??") + " = false");
//		System.out.println(test.isMatch66("abcde", "abc*?") + " = true");
//		System.out.println(test.isMatch66("abc", "*?*?*?*?") + " = false");
//		System.out.println(test.isMatch66("abcd", "*?*?*?*?") + " = true");
		
		System.out.println("*****************");
		System.out.println(test.isMatch8("aa", "a") + " = false");
		System.out.println(test.isMatch8("aa", "aa") + " = true");
		System.out.println(test.isMatch8("aaa", "aa") + " = false");
		System.out.println(test.isMatch8("aa", "*") + " = true");
		System.out.println(test.isMatch8("aa", "a*") + " = true");
		System.out.println(test.isMatch8("ab", "?*") + " = true");
		System.out.println(test.isMatch8("aa", "c*a*b*") + " = false");
		System.out.println(test.isMatch8("abce", "abc*?") + " = true");
		System.out.println(test.isMatch8("abce", "abc*??") + " = false");
		System.out.println(test.isMatch8("abcde", "abc*?") + " = true");
		System.out.println(test.isMatch8("abc", "*?*?*?*?") + " = false");
		System.out.println(test.isMatch8("abcd", "*?*?*?*?") + " = true");
		System.out.println(test.isMatch8("abaggaba", "aba") + " = false");
		System.out.println(test.isMatch8("c", "*?*") + " = true");

	}

	// "abce", "abc*?" true
	// "abce", "abc*??" false
	// "abcde", "abc*?" true
	// "abc", "*?*?*?*?" false
	// "abcd", "*?*?*?*?" true
}
