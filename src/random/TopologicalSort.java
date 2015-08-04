package random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import util.*;

public class TopologicalSort {

	// DFS
	public static List<GraphNode> topological(HashSet<GraphNode> set) {
		List<GraphNode> result = new ArrayList<GraphNode>();
		Hashtable<GraphNode, String> table = new Hashtable<GraphNode, String>();
		Iterator<GraphNode> it = set.iterator();
		while(it.hasNext()){
			GraphNode temp = it.next();
			table.put(temp, "white");
		}
		it = set.iterator();
		GraphNode cur = null;
		while (it.hasNext()) {
			cur = it.next();
			if(table.get(cur) == "white")
				visit(result, table, cur);
		}
		return result;
	}

	public static void visit(List<GraphNode> result,
			Hashtable<GraphNode, String> table, GraphNode source) {
		if(table.get(source) == "grey")
			return;
		if(table.get(source) == "white"){
			table.put(source, "grey");
			if(source.edge != null){
				List<GraphNode> list = source.edge;
				for(int i = 0; i < list.size(); i++)
					visit(result, table, list.get(i));
			}
			table.put(source, "black");
			result.add(0, source);
		}
	}
	
	public static void main(String[] args){
		GraphNode v1 = new GraphNode();
		v1.value = 1;
		GraphNode v2 = new GraphNode();
		v2.value = 2;
		GraphNode v3 = new GraphNode();
		v3.value = 3;
		GraphNode v4 = new GraphNode();
		v4.value = 4;
		GraphNode v5 = new GraphNode();
		v5.value = 5;
		List<GraphNode> list1 = new ArrayList<GraphNode>();
		list1.add(v2);
		list1.add(v4);
		v1.edge = list1;
		List<GraphNode> list3 = new ArrayList<GraphNode>();
		list3.add(v1);
		list3.add(v5);
		v3.edge = list3;
		List<GraphNode> list2 = new ArrayList<GraphNode>();
		list2.add(v4);
		v2.edge = list2;
		HashSet<GraphNode> set = new HashSet<GraphNode>();
		set.add(v1);
		set.add(v2);
		set.add(v3);
		set.add(v4);
		set.add(v5);
		List<GraphNode> result = topological(set);
		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i).value);
	}
}
