package linkedin;

public class CelebrityProblem {
	public static int getCelebrity(boolean[][] knows) {
		if(knows == null || knows.length == 0 || knows[0].length == 0)
			return -1;
		int N = knows.length;
		int candidate = 0;
		for (int j = 1; j < N; ++j) {
			if (knows[candidate][j]) {
				candidate = j;
			}
		}
		for (int i = 0; i < N; ++i) {
			if (knows[candidate][i] || !knows[i][candidate]) {
				return -1;
			}
		}
		return candidate;
	}

}
