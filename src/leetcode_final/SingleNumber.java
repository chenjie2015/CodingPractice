package leetcode_final;

import java.util.Arrays;

public class SingleNumber {
	public int singleNumber(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		Arrays.sort(A);
		for (int i = 0; i < A.length - 1; i += 2) {
			if (A[i] != A[i + 1])
				return A[i];
		}
		return A[A.length - 1];
	}

	// 异或运算性质，可以很好的保存数据而不使用第三方
	/*
	 * c = a ^ b
	 * a = b ^ c
	 * b = a ^ c 
	 * so, a ^ b ^ a = b
	 */
	public int singleNumber2(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int res = 0;
		for (int i = 0; i < A.length; i++)
			res ^= A[i];
		return res;
	}
	
	public static void main(String[] args){
		SingleNumber test = new SingleNumber();
		test.singleNumber2(new int[]{1,3,1,-1,3});
	}
}
