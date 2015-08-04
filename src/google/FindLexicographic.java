package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;

public class FindLexicographic {
	public static class Node {
		public char ch;
		public HashSet<Node> set = new HashSet<Node>();
		public Node(char ch) {
			this.ch = ch;
		}
	}

	public static ArrayList<Character> findOrder(ArrayList<String> dic) {
		if (dic.size() == 0)
			return new ArrayList<Character>();
		Hashtable<Character, Node> table = new Hashtable<Character, Node>();
		HashSet<Node> unvisited = new HashSet<Node>();
		int i = 0;
		String cur = null, next = dic.get(0);
		while (i < dic.size() - 1) {
			cur = next;
			next = dic.get(i + 1);
			for (int pos = 0; pos < cur.length() && pos < next.length(); pos++) {
				char cur_char = cur.charAt(pos);
				char next_char = next.charAt(pos);
				if (cur_char == next_char)
					continue;
				Node cur_node = null;
				Node next_node = null;
				if (table.containsKey(cur_char)) {
					cur_node = table.get(cur_char);
				} else {
					cur_node = new Node(cur_char);
					table.put(cur_char, cur_node);
				}
				if (table.containsKey(next_char))
					next_node = table.get(next_char);
				else {
					next_node = new Node(next_char);
					table.put(next_char, next_node);
				}
				if (!cur_node.set.contains(next_node))
					cur_node.set.add(next_node);
				unvisited.add(cur_node);
				unvisited.add(next_node);
			}
			i++;
		}
		return topologicalSort(unvisited);
	}

	public static ArrayList<Character> topologicalSort(HashSet<Node> unvisited) {
		if (unvisited.size() == 0)
			return new ArrayList<Character>();
		ArrayList<Character> result = new ArrayList<Character>();
		Hashtable<Node, String> status = new Hashtable<Node, String>();
		Iterator<Node> it = unvisited.iterator();
		Node cur;
		while (it.hasNext()) {
			cur = it.next();
			status.put(cur, "White");
		}
		it = unvisited.iterator();
		while (it.hasNext()) {
			cur = it.next();
			if (status.get(cur) == "White")
				visit(result, cur, status);
		}
		return result;
	}

	public static void visit(ArrayList<Character> result, Node cur,
			Hashtable<Node, String> status) {
		if (status.get(cur) == "Grey")
			return;
		if (status.get(cur) == "White") {
			status.put(cur, "Grey");
			if (!cur.set.isEmpty()) {
				Iterator<Node> it = cur.set.iterator();
				while (it.hasNext()) {
					visit(result, it.next(), status);
				}
			}
			status.put(cur, "Black");
			result.add(0, cur.ch);
		}
	}

	public static void main(String[] args) {
		ArrayList<String> dic = new ArrayList<String>();
		dic.add("apple");
		dic.add("boy");
		dic.add("counter");
		ArrayList<Character> result = findOrder(dic);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
}
