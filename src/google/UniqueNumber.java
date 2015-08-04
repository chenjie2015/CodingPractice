package google;

/*
 * 写一个函数生成满足下面三个条件的integer
 1. 非负
 2. 不能有重复数字
 3. 递增，既后面产生的比前面产生的要大
 */
public class UniqueNumber {
	public static String next(String input) {
		int n = input.length();
		if(n == 0 || n == 10)
			return "";
		int[] used = new int[10];
		// step 1: set used digits
		for (int i = 0; i < n; i++)
			used[input.charAt(i) - '0'] = 1;
		// step 2: find bigger unused digit at cur pos
		int i = n - 1;
		int k = 0;
		for (i = n - 1; i >= 0; i--) {
			int j = (input.charAt(i) - '0');
			k = j + 1;
			for (; k <= 9 && used[k] == 1; k++)
				;
			used[j] = 0;
			if (k <= 9)
				break;
		}
		StringBuilder sb = new StringBuilder();
		// step 2, till front, and still no valid pos example: "987"
		// next should be: "1023"
		if (i == -1) {
			sb.append("1");
			used[1] = 1;
		}
		// step 3.1 copy first digits
		for (int j = 0; j < i; j++)
			sb.append(input.charAt(j));
		if(i != -1){
			sb.append(k);
			used[k] = 1;
		}
		// step 3.2: set correct smallest and increasing digits from break
		// position
		int cur = 0;
		for (++i; i < n; i++) {
			while(used[cur] != 0)
				cur++;
			used[cur] = 1;
			sb.append(cur++);
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		System.out.println(next("987"));
		System.out.println(next("978"));
	}
}
