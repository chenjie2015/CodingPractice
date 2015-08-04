package leetcode_final;

public class DistinctSubsequences {
	// counter[i][j]表示S前i个字符和T前j个字符有多少distinct subsequence
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int ns = S.length();
		int nt = T.length();
		if (ns < nt)
			return 0;
		int[][] counter = new int[ns + 1][nt + 1];
		for (int i = 0; i <= ns; i++)
			counter[i][0] = 1;
		for (int i = 1; i <= ns; i++) {
			for (int j = 1; j <= nt; j++) {
				if (i < j)
					counter[i][j] = 0;
				else {
					if (S.charAt(i - 1) == T.charAt(j - 1))
						counter[i][j] = counter[i - 1][j - 1]
								+ counter[i - 1][j];
					//counter[i][j]包括两部分，一部分是当前T的字符不和当前S的字符配对（counter[i - 1][j]）
					// 一部分是T当前的字符和S当前的字符用来配对（counter[i - 1][j - 1]）
					else
						counter[i][j] = counter[i - 1][j];
				}
			}
		}
		return counter[ns][nt];
	}

	// 少 遍历半个矩阵
	public int numDistinct2(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int ns = S.length();
		int nt = T.length();
		if (ns < nt)
			return 0;
		int[][] counter = new int[ns + 1][nt + 1];
		for (int i = 0; i <= ns; i++)
			counter[i][0] = 1;
		for (int j = 1; j <= nt; j++) {
			for (int i = j; i <= ns; i++) {
				if (S.charAt(i - 1) == T.charAt(j - 1))
					counter[i][j] = counter[i - 1][j - 1] + counter[i - 1][j];
				else
					counter[i][j] = counter[i - 1][j];
			}
		}
		return counter[ns][nt];
	}

	public static void main(String[] args) {
		DistinctSubsequences test = new DistinctSubsequences();
		test.numDistinct("baba", "a");
	}
}
