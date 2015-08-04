package google;

// a1<=a2>=a3<=a4>=...
public class SpecialSorting {
	public static void sortArray(int[] s) {
		if (s.length == 0)
			return;
		int n = s.length;
		boolean flag = true;
		int current = s[0];
		for (int i = 0; i < n - 1; i++) {
			if (((flag) && (current > s[i + 1]))
					|| ((!flag) && (current < s[i + 1]))) {
				s[i] = s[i + 1];
			} else {
				s[i] = current;
				current = s[i + 1];
			}
			flag = !flag;
		}
		s[n - 1] = current;
		return;
	}

	// sorting solution
	public static void reorder(int[] arr) {
		if (arr.length == 0)
			return;
		boolean smallHead = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (smallHead && arr[i] > arr[i + 1] || !smallHead
					&& arr[i] < arr[i + 1]) {
				int tmp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = tmp;
			}
			smallHead = !smallHead;
		}
	}
	
	public static void main(String[] args){
		int[] a = {5, 4, 3, 2, 1, 0, 8, 11};
		sortArray(a);
		int[] b = {2, 4, 3, 2, 1, 0, 8, 0};
		reorder(b);
		System.out.println();
	}

}
