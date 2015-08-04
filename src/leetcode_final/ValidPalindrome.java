package leetcode_final;

public class ValidPalindrome {

	/**
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 * 
	 * Note: Have you consider that the string might be empty? This is a good
	 * question to ask during an interview.
	 * 
	 * For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 */

	public static boolean isPalindrome(String s) {
		if (s == null || s.length() <= 0) {
			return true;
		}
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) {
			char cur = s.charAt(start);
			char cur2 = s.charAt(end);
			if (cur < '0' || (cur > '9' && cur < 'A')
					|| (cur > 'Z' && cur < 'a') || cur > 'z') {
				start++;
				continue;
			}
			if (cur >= 'A' && cur <= 'Z') {
				System.out.println("Before conversion: " + cur);
				cur = (char) ((int) cur + 32);
			}
			if (cur2 < '0' || (cur2 > '9' && cur2 < 'A')
					|| (cur2 > 'Z' && cur2 < 'a') || cur2 > 'z') {
				end--;
				continue;
			}
			if (cur2 >= 'A' && cur2 <= 'Z') {
				cur2 = (char) ((int) cur2 + 32);
			}
			if (cur != cur2)
				return false;
			start++;
			end--;
		}
		return true;
	}
}
