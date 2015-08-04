package leetcode_final;

public class GasStation {

	// Solution 1 Brute Force. Fail.
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		for (int i = 0; i < gas.length; i++) {
			int curGas = gas[i];
			int curPos = i;
			int nextPos = (i + 1) % gas.length;
			while (true) {
				if (curGas < cost[curPos])
					break;
				curGas = curGas - cost[curPos] + gas[nextPos];
				curPos = nextPos;
				nextPos = (++nextPos) % gas.length;
				if (curPos == i)
					return i;
			}
		}
		return -1;
	}

	// Solution 2. Sum records valid index. Total means if there is a valid result
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int sum = 0, total = 0, len = gas.length, index = -1;
		for (int i = 0; i < len; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				index = i;
				sum = 0;
			}
		}
		return total >= 0 ? index + 1 : -1;
	}

	public static void main(String[] args) {
		GasStation test = new GasStation();
		test.canCompleteCircuit(new int[] { 2, 4 }, new int[] { 3, 4 });
	}
}
