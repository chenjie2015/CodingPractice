package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class UserLogs {
	public class Input{
		public int userId;
		public int login;
		public int logout;
		public Input(int userId, int login, int logout){
			this.userId = userId;
			this.login = login;
			this.logout = logout;
		}
	}
	private class Node{
		public int userId;
		public int timestamp;
		public boolean isLogin;
		public Node(int userId, int timestamp, boolean isLogin){
			this.userId = userId;
			this.timestamp = timestamp;
			this.isLogin = isLogin;
		}
	}
	private class Interval{
		public int num;
		public int login;
		public int logout;
		public Interval(int num, int login, int logout){
			this.num = num;
			this.login = login;
			this.logout = logout;
		}
	}
	public ArrayList<Node> preprocess(HashSet<Input> set){
		ArrayList<Node> result = new ArrayList<Node>();
		if(set.size() == 0)
			return result;
		Iterator<Input> it = set.iterator();
		while(it.hasNext()){
			Input cur = it.next();
			result.add(new Node(cur.userId, cur.login, true));
			result.add(new Node(cur.userId, cur.logout, false));
		}
		Collections.sort(result, new Comparator<Node>(){
			public int compare(Node n1, Node n2){
				if(n1.timestamp < n2.timestamp)
					return -1;
				else if (n1.timestamp > n2.timestamp)
					return 1;
				else{
					if(n1.isLogin && !n2.isLogin)
						return 1;
					else if(!n1.isLogin && n2.isLogin)
						return -1;
					else
						return 0;
				}
			}
		});
		return result;
	}
	public ArrayList<Interval> calculate(ArrayList<Node> list) throws Exception{
		ArrayList<Interval> result = new ArrayList<Interval>();
		if(list.size() == 0)
			return result;
		int counter = 0;
		int last = -1;
		for(int i = 0; i < list.size(); i++){
			Node cur = list.get(i);
			if(cur.isLogin){
				if(last == -1){
					last = cur.timestamp;
					counter++;
				} else if(last == cur.timestamp){
					counter++;
				} else {
					result.add(new Interval(counter, last, cur.timestamp));
					last = cur.timestamp;
					counter++;
				}
			} else {
				if(last == -1)
					throw new Exception("Error.");
				else{
					result.add(new Interval(counter, last, cur.timestamp));
					counter--;
					if(counter == 0)
						last = -1;
					else
						last = cur.timestamp;
				}
			}
		}
		return result;
	}
	
	public ArrayList<Interval> adjust(ArrayList<Interval> list){
		if(list.size() == 0)
			return list;
		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval cur = list.get(0);
		for(int i = 1; i < list.size(); i++){
			Interval next = list.get(i);
			if(cur.num == next.num && cur.logout == next.login)
				cur.logout = next.logout;
			else{
				result.add(cur);
				cur = next;
			}
		}
		result.add(cur);
		return result;
	}
	public static void main(String[] args) throws Exception{
		UserLogs test = new UserLogs();
		HashSet<Input> inputs = new HashSet<Input>();
		inputs.add(test.new Input(1, 0, 1));
		inputs.add(test.new Input(2, 0, 2));
		inputs.add(test.new Input(3, 1, 3));
		ArrayList<Node> nodes = test.preprocess(inputs);
		ArrayList<Interval> result = test.calculate(nodes);
		result = test.adjust(result);
		System.out.println();

	}
}
