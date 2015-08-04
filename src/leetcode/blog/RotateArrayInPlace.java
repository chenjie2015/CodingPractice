package leetcode.blog;

public class RotateArrayInPlace {
	// Q4 Rotating an array in place
	public static void rotateArray(int[] array, int k) {
		reverse(array, 0, array.length - 1);
		reverse(array, 0, k - 1);
		reverse(array, k, array.length - 1);
	}

	public static void reverse(int[] array, int left, int right) {
		int temp;
		while (left < right) {
			temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}
}
