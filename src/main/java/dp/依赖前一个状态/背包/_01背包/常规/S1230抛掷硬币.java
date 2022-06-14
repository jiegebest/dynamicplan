package dp.依赖前一个状态.背包._01背包.常规;

public class S1230抛掷硬币 {

	public double probabilityOfHeads(double[] prob, int target) {
		int n = prob.length;
		double[][] f = new double[n][target + 1];
		f[0][0] = 1 - prob[0];
		for (int i = 1; i < n; ++i) {
			f[i][0] = f[i - 1][0] * (1 - prob[i]);
		}
		if (target == 0) {
			return f[n - 1][0];
		}
		f[0][1] = prob[0];

		for (int i = 1; i < n; ++i) {
			for (int j = 1; j <= target; ++j) {
				f[i][j] = f[i - 1][j - 1] * prob[i] + f[i - 1][j] * (1 - prob[i]);
			}
		}
		return f[n - 1][target];
	}

}
