package leetcode_final;

public class LongestSubstringWithoutRepeatingCharacter {
	public int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int start = 0, res = 0;
		int[] pos = new int[256];
		for (int i = 0; i < 256; i++)
			pos[i] = -1;
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (start <= pos[(int) temp]) {
				res = Math.max(res, i - start);
				start = pos[(int) temp] + 1;
			}
			pos[(int) temp] = i;
		}
		res = Math.max(res, s.length() - start);
		return res;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacter test = new LongestSubstringWithoutRepeatingCharacter();
		test.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco");
	}
}
