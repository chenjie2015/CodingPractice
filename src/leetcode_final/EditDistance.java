package leetcode_final;
/*
 * Given two words word1 and word2,
 * find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// for all i and j, p[i,j] will hold the Levenshtein distance between
		// the first i characters of s and the first j characters of t;
		// note that p has (m+1)*(n+1) values
		int n1 = word1.length() + 1;
		int n2 = word2.length() + 1;

		int[][] p = new int[n1][n2];
		for (int i = 0; i < n1; ++i)
			p[i][0] = i;
		for (int j = 0; j < n2; ++j)
			p[0][j] = j;
		for (int i = 1; i < n1; ++i) {
			for (int j = 1; j < n2; ++j) {
				p[i][j] = p[i - 1][j - 1];
				if (word1.charAt(i - 1) != word2.charAt(j - 1))
					++p[i][j];// a substitution
				int min;
				if (p[i - 1][j] < p[i][j - 1])
					min = p[i - 1][j] + 1;// a deletion
				else
					min = p[i][j - 1] + 1;// an insertion
				if (min < p[i][j])
					p[i][j] = min;
			}
		}
		return p[n1 - 1][n2 - 1];
	}
}
