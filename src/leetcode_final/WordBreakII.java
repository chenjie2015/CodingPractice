package leetcode_final;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 *  Given a string s and a dictionary of words dict,
 *  add spaces in s to construct a sentence
 *  where each word is a valid dictionary word.
 *  
 *  Return all such possible sentences.
 *  
 *  For example, given
 *  s = "catsanddog",
 *  dict = ["cat", "cats", "and", "sand", "dog"].
 *  
 *  A solution is ["cats and dog", "cat sand dog"]. 
 */
public class WordBreakII {
	// DFS + Memorization
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		// 1. get the min and max length of words in dictionary, used for
		// pruning.
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (String str : dict) {
			min = Math.min(min, str.length());
			max = Math.max(max, str.length());
		}
		Map<String, ArrayList<String>> memorized = new HashMap<String, ArrayList<String>>();
		return wordBreakHelper(s, dict, min, max, memorized);
	}

	private ArrayList<String> wordBreakHelper(String s, Set<String> dict,
			int min, int max, Map<String, ArrayList<String>> memorized) {
		if (memorized.containsKey(s))
			return memorized.get(s);
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0)
			return res;
		if (dict.contains(s))
			res.add(s);
		// i pruning
		for (int i = min - 1; i < Math.min(s.length(), max); i++) {
			String prefix = s.substring(0, i + 1);
			if (dict.contains(prefix)) {
				String suffix = s.substring(i + 1);
				List<String> suffixBreak = wordBreakHelper(suffix, dict, min,
						max, memorized);
				if (!suffixBreak.isEmpty()) {
					for (String str : suffixBreak) {
						res.add(prefix + " " + str);
					}
				}
			}
		}
		memorized.put(s, res);
		return res;
	}

	// DP + back track
	public ArrayList<String> wordBreak2(String s, Set<String> dict) {
		int n = s.length();
		ArrayList<ArrayList<Integer>> pres = new ArrayList<ArrayList<Integer>>(
				n);
		// initialize
		for (int i = 0; i < n; ++i)
			pres.add(new ArrayList<Integer>());
		// DP. pres[i] stores position j where should insert space
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j <= i; ++j) {
				String suffix = s.substring(j, i + 1);
				if ((j == 0 || pres.get(j - 1).size() > 0) && dict.contains(suffix))
					pres.get(i).add(j);
			}
		}
		return getPath(s, n, pres);
	}

	public ArrayList<String> getPath(String s, int n, ArrayList<ArrayList<Integer>> pres) {
		ArrayList<String> res = new ArrayList<String>();
		for (int pre : pres.get(n - 1)) {
			if (pre == 0) {
				res.add(s.substring(0, n));
			} else {
				ArrayList<String> preres = getPath(s, pre, pres);
				String sub = s.substring(pre, n);
				for (String ss : preres)
					res.add(ss + " " + sub);
			}
		}
		return res;
	}

	// Pure DFS solution. Time O(2^n). Time limit Exceed.
	public ArrayList<String> res;

	public ArrayList<String> wordBreak3(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		res = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		if (s.length() < 1 || dict.size() == 0)
			return res;
		for (int i = 0; i <= s.length(); i++) {
			String suffix = s.substring(0, i);
			if (dict.contains(suffix)) {
				temp.add(suffix);
				DFS(s.substring(i), dict, temp);
				temp.remove(temp.size() - 1);
			}
		}
		return res;
	}

	public void DFS(String s, Set<String> dict, ArrayList<String> temp) {
		if (s.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < temp.size(); i++) {
				sb.append(temp.get(i));
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			res.add(sb.toString());
		}
		for (int i = 0; i <= s.length(); i++) {
			String suffix = s.substring(0, i);
			if (dict.contains(suffix)) {
				temp.add(suffix);
				DFS(s.substring(i), dict, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
