package util;

import java.util.List;

public class NestedListNode {
	public int value;
	public List<NestedListNode> list;
	public boolean isList;
	public NestedListNode next;
	public NestedListNode(int value, List<NestedListNode> list, boolean isList){
		this.value = value;
		this.list = list;
		this.isList = isList;
	}
}
