package leetcode.blog;
/*
 *     A long array A[] is given to you. There is a sliding window of size w
 *     which is moving from the very left of the array to the very right.
 *     You can only see the w numbers in the window.
 *     Each time the sliding window moves rightwards by one position.
 *     Following is an example:
    The array is [1 3 -1 -3 5 3 6 7], and w is 3.

    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

    Input: A long array A[], and a window width w
    Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
    Requirement: Find a good optimal way to get B[i]
 */
public class SlidingWindowMax {
	// Solution 1
	// O(nlgn)
	// use a heap, the element is the heap should be (value, index)
	// whenever the top element's index is out of range, we pop the element
	// so the heap size keeps changing
	
	// Solution 2
	// O(n)
	// doubly linked list, the size of the list doesn't need to be window size
	// for example, in the list [5, 3, 6], we can pop 5, 3, just keep 6
}
