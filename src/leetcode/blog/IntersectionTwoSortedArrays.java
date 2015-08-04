package leetcode.blog;

import java.util.ArrayList;

public class IntersectionTwoSortedArrays {
	// Q1 Find Intersection of two Sorted Arrays
	// if either A or B 's length is too big, try to use Binary Search should be
	// a good idea, which is O(mlgn)
	// this method is O(m + n)
	public static ArrayList<Integer> findIntersection(int[] A, int[] B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (A.length == 0 || B.length == 0)
			return res;
		for (int i = 0, j = 0; i < A.length && j < B.length;) {
			if (A[i] == B[j]) {
				res.add(A[i]);
				i++;
				j++;
			} else if (A[i] < B[j])
				i++;
			else
				j++;
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] A = { 1, 2, 3, 4, 5, 6, 7 };
		int[] B = { 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		ArrayList<Integer> res = findIntersection(A, B);
		for (int i = 0; i < res.size(); i++)
			System.out.print(res.get(i) + " ");
		System.out.println();
	}
}
