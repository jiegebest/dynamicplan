package 依赖前一个状态.状态机;

/**
 * 0-同色
 * 1-异色
 */
public class S276栅栏涂色 {

	public int numWays(int n, int k) {
		int[][] f = new int[n + 1][2];
		f[0][1] = k;

		for (int i = 2; i <= n; ++i) {
			f[i][0] = f[i - 1][1];
			f[i][1] = (f[i - 1][0] + f[i - 1][1]) * (k - 1);
		}

		return f[n][0] + f[n][1];
	}

}
