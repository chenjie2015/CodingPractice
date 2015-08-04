package google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Google skyline problem
 * Interval sorting
 * similar to WeightedInterval
 */
public class Skyline {
	static class Building{
		int start;
		int end;
		int height;
		Building(int start, int end, int height){
			this.start = start;
			this.end = end;
			this.height = height;
		}
		
	}
	
	static class Point{
		int x;
		int height;
		Point(int x, int height){
			this.x = x;
			this.height = height;
		}
	}
	
	public 	Queue<Point> findSkyLine(ArrayList<Building> list, int left, int right){
		if(left == right){
			Queue<Point> skyline = new LinkedList<Point>();
			skyline.offer(new Point(list.get(left).start, list.get(left).height));
			skyline.offer(new Point(list.get(left).end, 0));
			return skyline;
		}
		int mid = (left + right) / 2;
		Queue<Point> left_list = findSkyLine(list, left, mid);
		Queue<Point> right_list = findSkyLine(list, mid + 1, right);
		return mergeSkyLine(left_list, right_list);
	}
	
	public Queue<Point> mergeSkyLine(Queue<Point> left, Queue<Point> right){
		Queue<Point> res = new LinkedList<Point>();
		Point cur = null;
		int maxH = 0, left_h = 0, right_h = 0;;
		while(!left.isEmpty() && !right.isEmpty()){
			if(left.peek().x < right.peek().x){
				cur = left.poll();
				left_h = cur.height;
				maxH = left_h > right_h ? left_h : right_h;
			} else {
				cur = right.poll();
				right_h = cur.height;
				maxH = left_h > right_h ? left_h : right_h;
			}
			res.offer(new Point(cur.x, maxH));
		}
		while(!left.isEmpty())
			res.offer(left.poll());
		while(!right.isEmpty())
			res.offer(right.poll());
		return res;
	}
	
	public static void main(String[] args){
		ArrayList<Building> list = new ArrayList<Building>();
		list.add(new Building(1, 5, 11));
		list.add(new Building(2, 7, 6));
		list.add(new Building(3, 9, 13));
		list.add(new Building(12, 16, 7));
		list.add(new Building(14, 25, 3));
		list.add(new Building(19, 22, 18));
		Skyline test = new Skyline();
		Queue<Point> res = test.findSkyLine(list, 0, list.size() - 1);
		while(!res.isEmpty())
			System.out.println(res.peek().x + " x : height " + res.poll().height);
	}

}
