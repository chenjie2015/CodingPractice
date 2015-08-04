package leetcode_final;
/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
	public static int climbStairs(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else if(n == 2)
			return 2;
		int pre1 = 1;
		int pre2 = 2;
		int res = 0;
		for(int i = 3; i <= n; i++){
			res = pre1 + pre2;
			pre1 = pre2;
			pre2 = res;
		}
		return res;
	}
	public static int climbStairs2(int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for(int i = 2; i < n; i++)
			dp[i] = dp[i - 2] + dp[i - 1];
		return dp[n - 1];
	}
	public static void main(String[] args){
		System.out.println(ClimbingStairs.climbStairs(17));
		System.out.println(ClimbingStairs.climbStairs2(17));
	}
}
