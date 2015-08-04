package leetcode_final;

import java.util.ArrayList;

/*
 * Given a set of non-overlapping intervals,
 * insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted
 * according to their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16],
 * insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertIntervals {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int size = intervals.size();
		ArrayList<Interval> res = new ArrayList<Interval>();
		for (int i = 0; i < size; i++) {
			Interval cur = intervals.get(i);
			if (cur.end < newInterval.start)
				res.add(new Interval(cur.start, cur.end));
			else if (cur.end >= newInterval.start
					&& cur.start <= newInterval.end) {
				newInterval.start = Math.min(newInterval.start, cur.start);
				newInterval.end = Math.max(newInterval.end, cur.end);
			} else {// cur.start > newInterval.end
				res.add(newInterval);
				while (i < size) {
					res.add(new Interval(intervals.get(i).start, intervals
							.get(i).end));
					i++;
				}
			}
		}
		if (res.size() == 0 || res.get(res.size() - 1).end < newInterval.start)
			res.add(newInterval);
		return res;
	}

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
}
