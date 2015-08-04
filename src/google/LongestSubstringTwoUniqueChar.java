package google;

public class LongestSubstringTwoUniqueChar {
	public static String findLongest(String s) {
		int max = 0;
		int maxRight = 0;
		int maxLeft = 0;
		char c1 = s.charAt(0);
		int last1 = 0;
		char c2 = ' ';
		int n = s.length();
		int j = 0; // left index
		for (int i = 1; i < n; i++){ //  i right index
			if (s.charAt(i) == c1 || s.charAt(i) == c2) {
				if (s.charAt(i) == c1)
					last1 = i;
				if (i - j > max) {
					max = i - j;
					maxRight = i;
					maxLeft = j;
				}
			} else {
				c1 = c2;
				c2 = s.charAt(i);
				j = last1 + 1;
			}
		}
		return s.substring(maxLeft, maxRight + 1);
	}

	public static void main(String[] args) {
		System.out.println(findLongest("abcbcbcbcbcddd"));
		System.out.println(findLongest("abbbcccbbbcccd"));
	}
}
