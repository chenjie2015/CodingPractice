package leetcode.blog;

import java.util.ArrayList;
import java.util.Arrays;

public class GeneratePrimes {
	/*
	 * Q6 Generate a prime list from 0 up to n, using The Sieve of Erantosthenes
	 * param n The upper bound of the prime list (including n) param prime[] An
	 * array of truth value whether a number is prime
	 */
	public static ArrayList<Integer> generatePrime(int n) {
		boolean[] prime = new boolean[n + 1];
		if (n < 2)
			return new ArrayList<Integer>();
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		int limit = (int) Math.sqrt((double) n);
		for (int i = 2; i <= limit; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= n; j += i)
					prime[j] = false;
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++)
			if (prime[i])
				res.add(i);
		return res;
	}
}
