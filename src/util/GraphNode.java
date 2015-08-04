package util;

import java.util.List;

public class GraphNode {
	public int value;
	public List<GraphNode> edge;
	public GraphNode(){
		
	}
	public GraphNode(int value, List<GraphNode> list){
		this.value = value;
		this.edge = list;
	}
}
