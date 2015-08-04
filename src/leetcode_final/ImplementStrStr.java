package leetcode_final;

/*
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack,
 * or null if needle is not part of haystack.
 */
public class ImplementStrStr {
	// Solution 1. Brute force solution. Exceed large judge time limit
	public String strStr(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (haystack == null)
			return null;
		if (needle == null)
			return haystack;
		int len1 = haystack.length();
		int len2 = needle.length();
		if (len1 == 0 && len2 == 0)
			return "";
		if (len2 > len1)
			return null;
		int i = 0, j = 0, index = 0;
		while (index < len1) {
			while (i < len1 && j < len2
					&& haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			}
			if (j == len2)
				return haystack.substring(index);
			else {
				index++;
				i = index;
				j = 0;
			}
		}
		return null;
	}

	// KMP solution.
	public String strStr2(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (haystack == null)
			return null;
		if (needle == null)
			return haystack;
		int len1 = haystack.length();
		int len2 = needle.length();
		if (len2 == 0)
			return haystack;
		if (len2 > len1)
			return null;
		int[] prefix = new int[len2];
		int k = 0;
		prefix[0] = 0;
		// Compute prefix function
		for (int q = 1; q < len2; q++) {
			while (k > 0 && needle.charAt(k) != needle.charAt(q))
				k = prefix[k - 1];// pay attention here
			if (needle.charAt(k) == needle.charAt(q))
				k++;
			prefix[q] = k;
		}
		int q = 0;
		for (int i = 0; i < len1; i++) {
			while (q > 0 && needle.charAt(q) != haystack.charAt(i))
				q = prefix[q - 1];// pay attention here
			if (needle.charAt(q) == haystack.charAt(i))
				q++;
			if (q == len2)
				return haystack.substring(i - len2 + 1);
		}
		return null;
	}
	
	public static void main(String[] args){
		String haystack = "cdeababababacbdef";
		String needle = "ababacb";
		ImplementStrStr test = new ImplementStrStr();
		System.out.println(test.strStr2(haystack, needle));
	}
}
