package google;

import java.util.ArrayList;

public class CalculateExponent1000Bits {
	// Calculate (m^n)%(10^k). Keep the k integer numbers in an array.
	// Note: the integer numbers are in reversed in the array
	// Assume: m>0, n>0, k>0
	// Need to check validity outside of this function.
	// call calculate(5, 1234566789893943, 1000) to get result.
	// Time complexity: O((log n) * k * k)
	// Space complexity: O((log n) * k)
	public static ArrayList<Integer> calculate(int m, int n, int k) {
		if (n == 0) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			res.add(1);
			return res;
		} else if (n % 2 != 0) { // odd number
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(m);
			ArrayList<Integer> result1 = calculate(m, n - 1, k);
			return multiplyArrays(result1, tmp, k);
		} else {
			ArrayList<Integer> result1 = calculate(m, n / 2, k);
			return multiplyArrays(result1, result1, k);
		}
	}

	public static ArrayList<Integer> multiplyArrays(ArrayList<Integer> data1,
			ArrayList<Integer> data2, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int len1 = data1.size();
		int len2 = data2.size();
		for(int i = 0; i < len1; i++){
			int carry = 0;
			int value = 0;
			for(int j = 0; j < len2; j++){
				if(i + j >= k)
					break;
				value = data1.get(i) * data2.get(j);
				while(result.size() < i + j + 1)// similar idea
					result.add(0);
				value += result.get(i + j) + carry;
				carry = value / 10;
				result.set(i + j, value % 10);
			}
			if(i + len2 - 1 <= k - 1 && carry != 0){
				while(result.size() <= i + len2)// similar idea
					result.add(0);
				result.set(i + len2, result.get(i + len2) + carry);
			}
		}
		return result;
	}
	public static void main(String[] args){
		ArrayList<Integer> result = calculate(3, 10, 3);
		for(int i = result.size() - 1; i >= 0; i--){
			System.out.print(result.get(i));
		}
	}
}
