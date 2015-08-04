package leetcode_final;

/*
 * The gray code is a binary numeral system where two successive values
 * differ in only one bit.
 * Given a non-negative integer n representing
 * the total number of bits in the code,
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence
 * according to the above definition.
 * For now, the judge is able to judge based on
 *  one instance of gray code sequence. Sorry about that.
 *  
 *  二进制码->格雷码（编码）：从最右边一位起，依次将每一位与左边一位异或（XOR），
 *  作为对应格雷码该位的值，最左边一位不变（相当于左边是0）；
 *  
 *  格雷码->二进制码（解码）：从左边第二位起，将每位与左边一位解码后的值异或，
 *  作为该位解码后的值（最左边一位依然不变）。
 */
import java.util.ArrayList;

public class GaryCode {
	public ArrayList<Integer> grayCode(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		int size = 1 << n;
		// 1 left shifted with n digits
		for (int i = 0; i < size; i++) {
			res.add((i >> 1) ^ i);
		}
		return res;
	}
	
	public static void main(String[] args){
		GaryCode test = new GaryCode();
		test.grayCode(3);
		test.decode(3);
	}
	
	public int decode(int num){
		int mask;
		for(mask = num >> 1; mask != 0; mask = mask >> 1)
			num = num ^ mask;
		return num;
	}
}
