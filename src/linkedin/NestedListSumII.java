package linkedin;

import java.util.ArrayList;
import java.util.List;

public class NestedListSumII {
	public static int nestedSum(List<Object> list, int weight){
		if(list.size() == 0)
			return 0;
		int sum = 0;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) == null)
				continue;
			if(list.get(i) instanceof Integer)
				sum = sum + (Integer)list.get(i) * weight;
			else
				sum = sum + nestedSum((List<Object>)list.get(i), weight + 1);
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception{
//		int a;
//		System.out.println(a instanceof Integer);
//		a = 1;
//		System.out.println(a instanceof Integer);
		
		List<Object> list = new ArrayList<Object>();
		list.add(new Integer(1));
		list.add(new Integer(2));
		List<Object> list1 = new ArrayList<Object>();
		list1.add(new Integer(3));
		list1.add(new Integer(4));
		List<Object> list11 = new ArrayList<Object>();
		list11.add(new Integer(5));
		list11.add(new Integer(6));
		list1.add(list11);
		list.add(list1);
		list.add(new Integer(8));
		NestedListSumII it = new NestedListSumII();
		System.out.println(it.nestedSum(list, 1));
	}
}
