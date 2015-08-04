package google;

/*
 * 给9个9 还有 +,-,*, /, ()。让返回无法表示的最小的正数。
 */
public class NineNineCalculation {

	public static int findSmallest(){
		int n = 1;
		while(!isValid(n, 9))
			n++;
		return n;
	}
	public static boolean isValid(int target, int count) {
		if (count == 1){
			if (target == 9 || target == -9)
				return true;
			return false;
		}
		else if (target % 9 == 0 && isValid(target / 9, count - 1))
			return true;
		else if (isValid(target * 9, count - 1))
			return true;
		else if (isValid(target + 9, count - 1))
			return true;
		else if (isValid(target - 9, count - 1))
			return true;
		else if (isValid(9 - target, count - 1))
			return true;
		else if(9 % target == 0 && isValid(9 / target, count - 1))
			return true;
		else
			return false;
	}
	public static void main(String[] args){
		System.out.println(findSmallest());
	}
}
