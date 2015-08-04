package linkedin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class KthNearestPoints {
	public Point findKth(ArrayList<Point> list, int k){
		PriorityQueue<Point> minHeap
		= new PriorityQueue<Point>(k, new Comparator<Point>(){
			public int compare(Point p1, Point p2){
				int dis1 = p1.x * p1.x + p1.y * p1.y;
				int dis2 = p2.x * p2.x + p2.y * p2.y;
				return dis2 - dis1;
			}
		});
		int index = 0;
		int max = 0;
		while(index < list.size() && minHeap.size() < k){
			max = Math.max(max, distance(list.get(index)));
			minHeap.add(list.get(index++));
		}
		while(index < list.size()){
			int dis = distance(list.get(index));
			if(dis < max){
				max = dis;
				minHeap.poll();
				minHeap.add(list.get(index));
			}
			index++;
		}
		return minHeap.peek();
	}
	public int distance(Point p){
		return p.x * p.x + p.y * p.y;
	}
	public static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this. y = y;
		}
	}
	public static void main(String[] args){
		ArrayList<Point> list = new ArrayList<Point>();
		list.add(new Point(0, 0));
		list.add(new Point(1, 1));
		list.add(new Point(2, 2));
		list.add(new Point(3, 3));
		list.add(new Point(4, 4));
		list.add(new Point(5, 5));
		list.add(new Point(1, 1));
		list.add(new Point(2, 2));
		list.add(new Point(3, 3));
		KthNearestPoints test = new KthNearestPoints();
		Point res = test.findKth(list, 3);
		System.out.println(res.x + " : " + res.y);
	}
}
