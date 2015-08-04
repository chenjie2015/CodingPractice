package leetcode_final;

/*
 * A message containing letters from A-Z is being encoded
 * to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12",it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 */
public class DecodeWays {
	public int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = s.length();
		if (n == 0)
			return 0;
		int[] res = new int[n + 1];
		res[0] = 1;
		if (s.charAt(0) != '0')
			res[1] = 1;
		String temp;
		for (int i = 1; i < n; ++i) {
			temp = s.substring(i - 1, i + 1);// get digits of positions i-1 and i
			int value = Integer.parseInt(temp);
			if (s.charAt(i) != '0')
				res[i + 1] = res[i];
			if (value > 9 && value < 27) {
				res[i + 1] += res[i - 1];
			}
		}
		return res[n];
	}
	
	public static void main(String[] args){
		DecodeWays test = new DecodeWays();
		test.numDecodings("10");
	}
}
