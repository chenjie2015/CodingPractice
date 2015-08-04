package leetcode_final;

import java.util.Hashtable;

public class SingleNumberII {
	// Solution 1 Sorting then find. O(nlgn)
	// Solution 2 Hashing. Extra space. Time O(n). Space O(n)
	public int singleNumber(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if (table.containsKey(A[i]))
				table.put(A[i], table.get(A[i]) + 1);
			else
				table.put(A[i], 1);
		}
		for (int i = 0; i < A.length; i++) {
			if (table.get(A[i]) != 3)
				return A[i];
		}
		return 0;
	}

	// Solution 3 Bit manipulation.
	public int singleNumber2(int[] A) {
		int ones = 0, twos = 0;
		int commonBitMask = 0;
		for (int i = 0; i < A.length; i++) {
			/*
			 * The expression "one & A[i]" gives the bits that are there in both
			 * 'ones' and new element from A[]. We add these bits to 'twos'
			 * using bitwise OR
			 */
			twos |= (ones & A[i]);
			/*
			 * XOR the new bits with previous 'ones' to get all bits appearing
			 * odd number of times
			 */
			ones ^= A[i];
			/*
			 * The common bits are those bits which appear third time So these
			 * bits should not be there in both 'ones' and 'twos'.
			 * common_bit_mask contains all these bits as 0, so that the bits
			 * can be removed from 'ones' and 'twos'
			 */
			commonBitMask = ~(ones & twos);
			/*
			 * Remove common bits (the bits that appear third time) from 'ones'
			 */
			ones &= commonBitMask;
			/*
			 * Remove common bits (the bits that appear third time) from 'twos'
			 */
			twos &= commonBitMask;
		}
		return ones;
	}

	// Solution 4. Use an array of 32 length to count bits.
	public static int singleNumber3(int A[]) {
		int[] count = new int[32];
		int result = 0;
		for (int i = 0; i < 32; ++i) {
			count[i] = 0;
			for (int j = 0; j < A.length; ++j) {
				if (((A[j] >> i) & 1) != 0)
					count[i] = (count[i] + 1) % 3;
			}
			result |= (count[i] << i);
		}
		return result;
	}
	
	public static void main(String[] args){
		int[] array = new int[]{1, 1, 1, 2, 2, 2, 6};
		System.out.println(SingleNumberII.singleNumber3(array));
	}
}
