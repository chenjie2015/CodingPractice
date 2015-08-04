package leetcode_final;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int size = intervals.size();
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (size < 1)
			return res;
		Interval[] intervals_array = new Interval[size];
		for (int i = 0; i < size; i++) {
			intervals_array[i] = intervals.get(i);
		}
		Arrays.sort(intervals_array, comp);
		Interval cur = intervals_array[0];
		Interval next;
		for (int i = 1; i < size; i++) {
			next = intervals_array[i];
			if (next.start > cur.end) {
				res.add(new Interval(cur.start, cur.end));
				cur = next;
			} else {
				cur.end = cur.end > next.end ? cur.end : next.end;
			}
		}
		res.add(new Interval(cur.start, cur.end));
		return res;
	}

	public static Comparator<Interval> comp = new Comparator<Interval>() {
		public int compare(Interval i1, Interval i2) {
			if (i1.start > i2.start)
				return 1;
			else if (i1.start == i2.start)
				return 0;
			else
				return -1;
		}
	};
}
