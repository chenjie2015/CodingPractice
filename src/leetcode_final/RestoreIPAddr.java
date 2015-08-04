package leetcode_final;
/*
 * Given a string containing only digits,
 * restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
import java.util.ArrayList;

public class RestoreIPAddr {
	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		String cur = "";
		restore(res, cur, s, 4);
		return res;
	}

	public void restore(ArrayList<String> res, String cur, String s, int left) {
		if (left == 0) {
			if (s.length() == 0) {
				res.add(cur.substring(0, cur.length() - 1));
				return;
			}
		}
		if (left * 3 < s.length())
			return;
		int num = 0;
		if (s.length() > 0) {
			num = Integer.parseInt(s.substring(0, 1));
			if (num >= 0 && num < 256) {
				String temp = cur + s.substring(0, 1) + ".";
				restore(res, temp, s.substring(1), left - 1);
			}
		}
		if (s.length() > 1) {
			if (s.charAt(0) == '0')
				return;
			num = Integer.parseInt(s.substring(0, 2));
			if (num >= 0 && num < 256) {
				String temp = cur + s.substring(0, 2) + ".";
				restore(res, temp, s.substring(2), left - 1);
			}
		}
		if (s.length() > 2) {
			if (s.charAt(0) == '0')
				return;
			num = Integer.parseInt(s.substring(0, 3));
			if (num >= 0 && num < 256) {
				String temp = cur + s.substring(0, 3) + ".";
				restore(res, temp, s.substring(3), left - 1);
			}
		}
	}

	public ArrayList<String> restoreIpAddresses2(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		String cur = "";
		restore2(res, cur, s, 0, 4);
		return res;
	}

	public void restore2(ArrayList<String> res, String temp, String s,
			int start, int left) {
		if (left == 0) {
			if (start == s.length()) {
				res.add(temp.substring(1));
			}
			return;
		}
		int x = 0;
		for (int i = start; i < start + 4 && i < s.length(); ++i) {
			x = x * 10 + s.charAt(i) - '0';
			if (x > 255 || x < 0)
				break;
			String str = temp + ".";
			String st = s.substring(start, i + 1);
			if (st.length() > 1 && st.charAt(0) == '0')
				break;
			str += st;
			restore2(res, str, s, i + 1, left - 1);
		}
	}

	public static void main(String[] args) {
		RestoreIPAddr test = new RestoreIPAddr();
		System.out.println(test.restoreIpAddresses2("255255255255"));
	}
}
