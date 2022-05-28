package 依赖前一个状态.背包._01背包;

public class S1230抛掷硬币 {

	public double probabilityOfHeads(double[] prob, int target) {
		int n = prob.length, m = target;
		double[][] f = new double[n][m + 1];
		if (m > 0) {
			f[0][1] = prob[0];
		}
		f[0][0] = 1 - prob[0];
		for (int i = 1; i < n; ++i) {
			f[i][0] = f[i - 1][0] * (1 - prob[i]);
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 1; j <= m; ++j) {
				f[i][j] = f[i - 1][j - 1] * prob[i] + f[i - 1][j] * (1 - prob[i]);
			}
		}
		return f[n - 1][m];
	}

}
