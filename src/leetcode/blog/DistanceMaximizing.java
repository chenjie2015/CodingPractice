package leetcode.blog;

/*
 * Given an array A of integers,
 * find the maximum of j-i subjected to the constraint of A[i] < A[j].
 */
public class DistanceMaximizing {
	// Solution 1
	// brute force O(n^2)
	
	// Solution 2
	// sort O(nlgn)
	// then build up a lookup table in O(n)
	// height         1, 2, 2, 3, 3, 3, 4, 5
	// original index 4, 3, 6, 1, 5, 7, 0, 2
	// lookup table   7, 7, 7, 7, 7, 7, 2, 2
	
	// Solution 3
	// O(n)
	// divide array into non-decreasing segments
	// height 4, 3, 5, 2, 1, 3, 2, 3
	// index  0, 1, 2, 3, 4, 5, 6, 7
	// then index 0, 1, 3, 4, 6 are valid start point, ie i
	// then find j from right to left
}
