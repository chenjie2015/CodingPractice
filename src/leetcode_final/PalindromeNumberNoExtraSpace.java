package leetcode_final;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string,
 * note the restriction of using extra space.
 * You could also try reversing an integer.
 * However, if you have solved the problem "Reverse Integer",
 * you know that the reversed integer might overflow.
 * How would you handle such case?
 * There is a more generic way of solving this problem.
 */
public class PalindromeNumberNoExtraSpace {
	public boolean isPalindrome(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0)
			return false;
		int div = 1;
		while (x / div >= 10) {
			div = div * 10;
		}
		while (x != 0) {
			int left = x / div;
			int right = x % 10;
			if (left != right)
				return false;
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}

	// Recursive solution
	public int y;

	public boolean isPalindrome_helper(int x) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		if (isPalindrome_helper(x / 10) && (x % 10 == y % 10)) {
			y /= 10;
			return true;
		} else {
			return false;
		}
	}

	public boolean isPalindrome2(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		y = x;
		return isPalindrome_helper(x);
	}

	// Practice
	public boolean isPalindrome3(int x) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (x < 0)
			return false;
		int factor = 1;
		int temp = x;
		while (temp >= 10) {
			factor *= 10;
			temp /= 10;
		}
		while (x != 0) {
			int left = x / factor;
			int right = x % 10;
			if (left != right)
				return false;
			x = x % factor;
			x /= 10;
			factor /= 100;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeNumberNoExtraSpace test = new PalindromeNumberNoExtraSpace();
		test.isPalindrome3(1370000731);
	}
}
