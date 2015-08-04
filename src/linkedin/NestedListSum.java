package linkedin;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NestedListSum {
		private Stack<Object> stack = null;
		private Stack<Integer> depth = null;
		
		public NestedListSum(List<Object> list){
			stack = new Stack<Object>();
			depth = new Stack<Integer>();
			stack.push(list);
			depth.push(0);
			skipNullPointer();
		}
		
		private boolean hasNext(){
			return !stack.isEmpty();
		}
		
		private Integer next() throws Exception{
			if(!hasNext())
				throw new Exception("No content.");
			int result = (Integer)stack.pop();
			int cur_dep = depth.pop();
			skipNullPointer();
			return result * cur_dep;
		}
		
		private void skipNullPointer(){
			while(!stack.isEmpty() && !(stack.peek() instanceof Integer)){
				Object obj = stack.pop();
				int cur_dep = depth.pop();
				if(obj == null)
					continue;
				List<Object> cur = (List<Object>)obj;
				cur_dep++;
				for(int i = cur.size() - 1; i >= 0; i--){
					stack.push(cur.get(i));
					depth.push(cur_dep);
				}
			}
		}
		
		public int sum() throws Exception{
			int sum = 0;
			while(hasNext()){
				sum += next();
			}
			return sum;
		}
		
		public static void main(String[] args) throws Exception{
//			int a;
//			System.out.println(a instanceof Integer);
//			a = 1;
//			System.out.println(a instanceof Integer);
			
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
			list.add(new Integer(7));
			NestedListSum it = new NestedListSum(list);
			System.out.println(it.sum());
		}
}
