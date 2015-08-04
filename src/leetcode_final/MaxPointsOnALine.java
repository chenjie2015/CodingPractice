package leetcode_final;

import java.util.Hashtable;

public class MaxPointsOnALine {
	public static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
	// 以每个点为中心计算相同斜率的点数，O(n^2)
//		public int maxPoints(Point[] points) {  
//		        // IMPORTANT: Please reset any member data you declared, as  
//		        // the same Solution instance will be reused for each test case.  
//		        Hashtable<double,int> mp;  
//		        int maxNum = 0;  
//		        for(int i = 0; i < points.size(); i++)  
//		        {  
//		            mp.clear();  
//		            mp[INT_MIN] = 0;  
//		            int duplicate = 1;  
//		            for(int j = 0; j < points.size(); j++)  
//		            {  
//		                if(j == i) continue;  
//		                if(points[i].x == points[j].x && points[i].y == points[j].y)  
//		                {  
//		                    duplicate++;  
//		                    continue;  
//		                }  
//		                float k = points[i].x == points[j].x ? INT_MAX : (float)(points[j].y - points[i].y)/(points[j].x - points[i].x);  
//		                mp[k]++;  
//		            }  
//		            unordered_map<float, int>::iterator it = mp.begin();  
//		            for(; it != mp.end(); it++)  
//		                if(it->second + duplicate > maxNum)  
//		                    maxNum = it->second + duplicate;  
//		        }  
//		        return maxNum;  
//		    }   

	
	// 150 Interview Question. Not working.
	public int maxPoints2(Point[] points) {
		int max = 0;
		Hashtable<Line, Integer> table = new Hashtable<Line, Integer>();
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				Line line = new Line(points[i], points[j]);
				System.out.println(points[i].x +":" + points[i].y + " " + points[j].x +":" + points[j].y);
				System.out.println(line.slope + " : " + line.intercept);
				System.out.println("Hashcode:" + line.hashCode());
				if (!table.containsKey(line))
					table.put(line, 0);
				table.put(line, table.get(line) + 1);
				if (max == 0 || table.get(line) > max)
					max = table.get(line);
			}
		}
		return max;
	}

	public class Line {
		private static final double epsilon = .0001;
		public boolean vertical = false;
		public double slope;
		public double intercept;

		public Line(Point p1, Point p2) {
			if (Math.abs(p1.x - p2.x) > epsilon) {
				slope = (p1.y - p2.y) / (p1.x - p2.x);
				intercept = p1.y - slope * p1.x;
			} else {
				vertical = true;
				intercept = p1.x;
			}
		}

		public boolean isEqual(double a, double b) {
			return (Math.abs(a - b) <= epsilon);
		}

		@Override
		public int hashCode() {
			int sl = (int) (slope * 1000);
			int in = (int) (intercept * 1000);
			return sl | in;
		}

		@Override
		public boolean equals(Object o) {
			Line line = (Line) o;
			if (isEqual(line.slope, slope)
					&& isEqual(line.intercept, intercept)
					&& line.vertical == vertical)
				return true;
			return false;
		}
	}
	
	public static void main(String[] args){
		MaxPointsOnALine test = new MaxPointsOnALine();
		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 0);
		//Point[] arr = {p1, p2};
		Point[] arr = {p1, p2, new Point(1, 2), new Point(1, -1), new Point(2, -2)};
//		System.out.println(test.maxPoints(arr));
	}

}
