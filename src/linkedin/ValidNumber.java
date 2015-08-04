package linkedin;

/*
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one.
 */
public class ValidNumber {
	public int index;

	public boolean isNumber(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		index = 0;
		if (s.length() == 0)
			return false;
		// 去掉空格
		while (index < s.length() && s.charAt(index) == ' ')
			index++;

		// e 之前是否为数字
		if (!isNum(s, false))
			return false;
		// e 之后是否为数字
		if (index < s.length() && s.charAt(index) == 'e') {
			index++;
			if (!isNum(s, true))
				return false;
		}

		while (index < s.length() && s.charAt(index) == ' ')
			index++;
		if (index == s.length())
			return true;
		else
			return false;
	}

	public boolean isNum(String s, boolean flag) {
		boolean res = false;
		if (index < s.length()
				&& (s.charAt(index) == '-' || s.charAt(index) == '+'))
			index++;
		boolean dot = false;
		while (index < s.length()) {
			if (s.charAt(index) <= '9' && s.charAt(index) >= '0') {
				res = true;
				index++;
			} else if (s.charAt(index) == '.') {
				if (flag) // e 后面数字不带点
					return false;
				if (dot) // 多于一个点
					return false;
				dot = true;
				index++;
			} else if (s.charAt(index) == 'e' || s.charAt(index) == ' ')
				return res;
			else
				return false;
		}
		return res;
	}
}
