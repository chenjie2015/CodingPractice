package leetcode.blog;

/*
 *     Imagine you have a special keyboard with the following keys:

 A
 Ctrl+A
 Ctrl+C
 Ctrl+V

 where CTRL+A, CTRL+C, CTRL+V each acts as one function key for “Select All”,
 “Copy”, and “Paste” operations respectively.
 If you can only press the keyboard for N times (with the above four keys),
 please write a program to produce maximum numbers of A.
 If possible, please also print out the sequence of keys.

 That is to say, the input parameter is N (No. of keys that you can press),
 the output is M (No. of As that you can produce).
 */
public class AControlACV {
	public static int findMaxK(int n) {
		int power = 2;
		double max = 0.0;
		int maxK = 0;
		while (n > 0) {
			n -= 2;
			double t = (double) n / power;
			double r = Math.pow(t, (double) power);
			if (r > max) {
				maxK = power;
				max = r;
			}
			power++;
		}
		return maxK;
	}

	public static int f(int n) {
		if (n <= 7)
			return n;
		int k = findMaxK(n);
		int sum = n - 2 * (k - 1);
		int mul = 1;
		while (k > 0) {
			int avg = sum / k;
			mul *= avg;
			k--;
			sum -= avg;
		}
		assert (sum == 0);
		return mul;
	}

	public static long f2(int n) {
		if (n <= 7)
			return n;
		int k = 2; // define k as the steps number, the default is 2 when n > 7
		int kmax = (n + 2) / 4;
		// n-2(k-1) = ax+(a+1)(k-x) >= ak ==> k<=(n+2)/(a+2) ==> k<=(n+2)/4
		int sum = 0; // sum = n-2(k-1)
		long mul = 1; // the total times, e.g. to 3A3D, the total times is
		int a; // aAaD–(a+1)D(a+1)D, there are (k-x) times a, (k) times a+1
		int x; // aAaD–(a+1)D(a+1)D, there are (k-x) times a, (k) times a+1

		long mulMax = 1;
		// int aM = 0;
		// int xM = 0;
		// int kM = 0;

		while (k <= kmax) {
			sum = n - 2 * (k - 1);
			a = sum / k;
			x = sum % k;
			mul = (long) Math.pow(a, k - x) * (long) Math.pow(a + 1, x);
			if (mul > mulMax) {
				mulMax = mul;
				// aM = a;
				// xM = x;
				// kM = k;
			}
			k++;
		}
		// System.out.print("\t\t" + mulMax + "\t" + getSteps(aM, xM, kM));
		return mulMax;
	}

	public static void main(String[] args) {
		System.out.println(f(15));
		System.out.println(f2(15));
	}
}
