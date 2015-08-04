package leetcode_final;

import java.util.ArrayList;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] sum = new int[triangle.size()];
		if (triangle.size() < 1)
			return 0;
		int min = sum[0], pre_sum = 0;
		for (int i = 0; i < triangle.size(); i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					pre_sum = sum[j];
					sum[j] = sum[j] + triangle.get(i).get(j);
					min = sum[0];
				} else if (j == i)
					sum[j] = pre_sum + triangle.get(i).get(j);
				else {
					int temp = pre_sum;
					pre_sum = sum[j];
					sum[j] = temp < sum[j] ? temp + triangle.get(i).get(j)
							: sum[j] + triangle.get(i).get(j);
				}
				if (sum[j] < min)
					min = sum[j];
			}
		}
		return min;
	}

	public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (triangle.size() == 0)
			return 0;
		int[] dp = new int[triangle.size()];
		int min = 0;
		int pre = 0;
		for (int i = 0; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (j == 0) {
					pre = dp[j];
					dp[j] = dp[j] + triangle.get(i).get(j);
					min = dp[j];
				} else if (j == triangle.get(i).size() - 1)
					dp[j] = pre + triangle.get(i).get(j);
				else {
					int temp = dp[j];
					dp[j] = pre < dp[j] ? pre + triangle.get(i).get(j) : dp[j]
							+ triangle.get(i).get(j);
					pre = temp;
				}
				min = min < dp[j] ? min : dp[j];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> line = new ArrayList<Integer>();
		line.add(-1);
		res.add(new ArrayList<Integer>(line));
		line.clear();
		line.add(2);
		line.add(3);
		res.add(new ArrayList<Integer>(line));
		line.clear();
		line.add(1);
		line.add(-1);
		line.add(-3);
		res.add(new ArrayList<Integer>(line));
		Triangle test = new Triangle();
		test.minimumTotal2(res);
	}
}
