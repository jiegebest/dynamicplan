package 依赖前一个状态99.背包16._01背包7;

public class S1230抛掷硬币 {

	public double probabilityOfHeads(double[] prob, int target) {
		int m = prob.length, n = target;
		double[][] f = new double[m][n + 1];
		if (n > 0) {
			f[0][1] = prob[0];
		}
		f[0][0] = 1 - prob[0];
		for (int i = 1; i < m; ++i) {
			f[i][0] = f[i - 1][0] * (1 - prob[i]);
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 1; j <= n; ++j) {
				f[i][j] = f[i - 1][j - 1] * prob[i] + f[i - 1][j] * (1 - prob[i]);
			}
		}
		return f[n - 1][n];
	}

}
