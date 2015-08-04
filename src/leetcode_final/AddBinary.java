package leetcode_final;

/*
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len1 = a.length();
		if (len1 == 0)
			return b;
		int len2 = b.length();
		if (len2 == 0)
			return a;
		int i = len1 - 1, j = len2 - 1, carry = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 && j >= 0) {
			char m = a.charAt(i);
			char n = b.charAt(j);
			int temp = m - '0' + n - '0' + carry;
			carry = temp / 2;
			sb.append(temp % 2);
			i--;
			j--;
		}
		while (i >= 0) {
			char m = a.charAt(i);
			int temp = m - '0' + carry;
			carry = temp / 2;
			sb.append(temp % 2);
			i--;
		}
		while (j >= 0) {
			char n = b.charAt(j);
			int temp = n - '0' + carry;
			carry = temp / 2;
			sb.append(temp % 2);
			j--;
		}
		if (carry == 1)
			sb.append(carry);
		sb.reverse();
		return sb.toString();
	}
}
