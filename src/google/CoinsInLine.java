package google;
/* P1 = Ai + min { P(i+2, j), P(i+1, j-1) }
 * P2 = Aj + min { P(i+1, j-1), P(i, j-2) }
 * P(i, j) = max { P1, P2 }
        = max { Ai + min { P(i+2, j),   P(i+1, j-1) },
                Aj + min { P(i+1, j-1), P(i,   j-2) } }
 */
public class CoinsInLine {
	public static int getCoins(int[] A) {
		int len = A.length;
		int[][] P = new int[len + 1][len + 1];
		int a, b, c;
		for (int i = 0; i < len; i++) {
			for (int m = 0, n = i; n < len; m++, n++) {
				a = ((m + 2 <= len - 1) ? P[m + 2][n] : 0);
				b = ((m + 1 <= len - 1 && n - 1 >= 0) ? P[m + 1][n - 1] : 0);
				c = ((n - 2 >= 0) ? P[m][n - 2] : 0);
				P[m][n] = Math
						.max(A[m] + Math.min(a, b), A[n] + Math.min(b, c));
			}
		}
		return P[0][len - 1];
	}
}
