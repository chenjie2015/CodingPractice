package leetcode.blog;

public class StringReplacement {
	/*
	 * Replace all occurrence of the given pattern to ‘X’. For example, given
	 * that the pattern=”abc”, replace “abcdeffdfegabcabc” with “XdeffdfegX”.
	 * Note that multiple occurrences of abc’s that are contiguous will be
	 * replaced with only one ‘X’.
	 */
	public static String Q15replace(String str, String pattern){
		if(str == null || pattern == null || pattern.length() > str.length())
			return str;
		StringBuilder sb = new StringBuilder("");
		int lastStart = 0, curStart = 0, curEnd = 0;
		while(curStart != str.length()){
			if(curStart + pattern.length() <= str.length() && match(str.substring(curStart, curStart + pattern.length()), pattern)){
				sb.append(str.substring(lastStart, curStart));
				if(sb.length() == 0 || sb.charAt(sb.length() - 1) != 'X')
					sb.append('X');
				curEnd = curStart + pattern.length();
				lastStart = curEnd;
				curStart = curEnd;
			} else {
				curStart++;
			}
		}
		if(curEnd != str.length())
			sb.append(str.substring(lastStart, str.length()));
		return sb.toString();
	}
	public static boolean match(String s, String p){
		int i = 0;
		while(i != s.length() && i != p.length()){
			if(s.charAt(i) != p.charAt(i))
				return false;
			i++;
		}
		if(i == p.length())
			return true;
		return false;
	}
}
