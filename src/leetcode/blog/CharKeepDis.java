package leetcode.blog;

import java.util.Arrays;

public class CharKeepDis {
	/*
	 * Q7 Given a string of lowercase characters, reorder them such that the
	 * same characters are at least distance d from each other. Input: { a, b, b
	 * }, distance = 2 Output: { b, a, b }
	 */
	public static int findMax(int freqeuncy[], boolean excep[]) {
		int max_i = -1;
		int max = -1;
		for (int i = 0; i < 26; i++) {
			if (!excep[i] && freqeuncy[i] > 0 && freqeuncy[i] > max) {
				max = freqeuncy[i];
				max_i = i;
			}
		}
		return max_i;
	}

	public static char[] keepDis(char[] str, int d) {
		int n = str.length;
		char[] res = new char[n];
		int freqeuncy[] = new int[26];
		for (int i = 0; i < n; i++)
			freqeuncy[str[i] - 'a']++;
		int distance[] = new int[26];
		boolean excep[] = new boolean[26];
		for (int i = 0; i < n; i++) {
			Arrays.fill(excep, false);
			boolean done = false;
			while (!done) {
				int j = findMax(freqeuncy, excep);
				if (j == -1) {
					System.out.println("Invalid inputs.");
					return res;
				}
				excep[j] = true;
				if (distance[j] <= 0) {
					res[i] = (char) (j + 'a');
					freqeuncy[j]--;
					distance[j] = d;
					done = true;
				}
			}
			for (int k = 0; k < 26; k++)
				distance[k]--;
		}
		return res;
	}
}
