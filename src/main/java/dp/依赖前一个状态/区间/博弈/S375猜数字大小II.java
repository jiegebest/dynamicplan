package dp.依赖前一个状态.区间.博弈;

public class S375猜数字大小II {

	public int getMoneyAmount(int n) {
		int[][] f = new int[n + 1][n + 1];
		for (int i = n - 1; i >= 1; --i) {
			for (int j = i + 1; j <= n; ++j) {
				f[i][j] = f[i][j - 1] + j;
				for (int k = i; k < j; ++k) {
					f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
				}
			}
		}
		return f[1][n];
	}

}