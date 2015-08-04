package leetcode_final;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (node == null)
			return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		Hashtable<UndirectedGraphNode, UndirectedGraphNode> hashtable = new Hashtable<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode node_copy = new UndirectedGraphNode(node.label);
		hashtable.put(node, node_copy);
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				if (!hashtable.containsKey(neighbor)) {
					UndirectedGraphNode neighbor_copy = new UndirectedGraphNode(
							neighbor.label);
					hashtable.get(cur).neighbors.add(neighbor_copy);
					hashtable.put(neighbor, neighbor_copy);
					queue.add(neighbor);
				} else {
					hashtable.get(cur).neighbors.add(hashtable.get(neighbor));
				}
			}
		}
		return node_copy;
	}
}
