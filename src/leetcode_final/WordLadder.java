package leetcode_final;

/*
 * Given two words (start and end), and a dictionary,
 * find the length of shortest transformation sequence from start to end,
 * such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * 
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (start.length() != end.length())
			return 0;
		if (start.equals(end))
			return 2;
		int path = 0;

		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		HashSet<String> hitted = new HashSet<String>();
		hitted.add(start);
		int queue_counter = 1;
		int set_counter = 0;

		while (!queue.isEmpty()) {
			String s = queue.poll();
			queue_counter--;
			HashSet<String> valid_neighbor = nextHit(s, dict, hitted);
			set_counter = valid_neighbor.size();
			for (String str : valid_neighbor) {
				if (str.equals(end))
					return path + 2;
				else
					queue.offer(str);
			}
			if (queue_counter == 0) {
				path++;
				queue_counter = set_counter;
			}
		}
		return 0;
	}

	private HashSet<String> nextHit(String s, HashSet<String> dict,
			HashSet<String> hitted) {
		HashSet<String> valid_neighbor = new HashSet<String>();
		for (int len = 0; len < s.length(); len++) {
			StringBuilder sb = new StringBuilder(s);
			for (char ch = 'a'; ch <= 'z'; ch++) {
				sb.setCharAt(len, ch);
				String test_case = sb.toString();
				if (dict.contains(test_case) && !hitted.contains(test_case)) {
					hitted.add(test_case);
					valid_neighbor.add(test_case);
				}
			}
		}
		return valid_neighbor;
	}

	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength(start, end, dict));
	}
}
