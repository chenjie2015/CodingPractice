package leetcode_final;

public class Candy {
	public int candy(int[] ratings) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int len = ratings.length;
		if(len == 0)
			return 0;
		int minSum = len;
		// Each child must have at least one candy. Better start this way.
		// I got bugs when start with minSum = 0
		int curCandy = 1;
		int[] candy = new int[ratings.length];
		for(int i = 1; i < len; i++){
			if(ratings[i - 1] < ratings[i])
				++curCandy;
			else
				curCandy = 0;
			candy[i] = curCandy;
		}
		curCandy = 0;
		for(int i = len - 2; i >= 0;i--){
			if(ratings[i] > ratings[i + 1])
				++curCandy;
			else
				curCandy = 0;
			minSum += Math.max(candy[i], curCandy);
		}
		minSum += candy[len - 1];
		return minSum;
	}
	
	public static void main(String[] args){
		Candy test = new Candy();
		test.candy(new int[]{1, 2});
	}
}
