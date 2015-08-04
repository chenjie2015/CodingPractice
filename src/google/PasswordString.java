package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class PasswordString {
	// Assume memory is not an issue here.
	// It is easy to find a memory efficiency way
	public static String calculate(ArrayList<String> input) {
		// assume all the strings are in an array vector<string> input;
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < input.size(); ++i) {
			String node = input.get(i);
			result.append(node);
			HashSet<String> visited = new HashSet<String>();
			boolean succeed = DFS(visited, node, result);
			if (succeed)
				return result.toString();
		}
		// Can not generate!
		return "";
	}

	public static boolean DFS(HashSet<String> visited, String node,
			StringBuilder result) {
		visited.add(node);
		if (visited.size() == 10000)
			return true;
		String next = node.substring(1, 4);
		for (int i = 0; i < 10; ++i) {
			char ch = (char) ('0' + i);
			next += ch;
			if (!visited.contains(next)) {
				result.append(ch);
				boolean bSucceed = DFS(visited, next, result);
				if (bSucceed)
					return true;
				result.deleteCharAt(result.length() - 1);
			}
		}
		visited.remove(node);
		return false;
	}

	/*
	 * public static String calculate(HashSet<String> input) { // assume all the
	 * strings are in an array vector<string> input; StringBuffer result = new
	 * StringBuffer(""); Iterator<String> it = input.iterator(); HashSet<String>
	 * visited = new HashSet<String>(); while (it.hasNext()) { String cur =
	 * it.next(); result.append(cur); visited.add(cur); if (DFS(visited,
	 * result)) return result.toString(); visited.remove(cur); } return ""; }
	 * 
	 * public static boolean DFS(HashSet<String> visited, StringBuffer sb) { if
	 * (visited.size() == 10000) return true; String prefix =
	 * sb.substring(sb.length() - 3, sb.length()); for (int i = 0; i <= 9; i++)
	 * { String next_node = prefix + i; if (!visited.contains(next_node)) {
	 * sb.append(i); visited.add(next_node); if (DFS(visited, sb)) return true;
	 * visited.remove(next_node); sb.delete(sb.length() - 1, sb.length()); } }
	 * return false; }
	 */

	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		for (int i = 0; i < 10; i++)
			input.add("000" + i);
		for (int i = 10; i < 100; i++)
			input.add("00" + i);
		for (int i = 100; i < 1000; i++)
			input.add("0" + i);
		for (int i = 1000; i < 10000; i++)
			input.add("" + i);
		System.out.println(calculate(input));
	}

}
