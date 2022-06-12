package dp.依赖后面的状态;

/**
 * 爱丽丝以 0 分开始分数不超过 n 的概率 > 这个是终态
 * 中间态和起始态 i > 0
 */
public class S837新21点 {

	public double new21Game(int n, int k, int maxPts) {
		if (k == 0) {
			return 1;
		}

		double[] f = new double[k + maxPts];
		for (int i = k; i <= n && i < k + maxPts; ++i) {
			f[i] = 1;
		}
		f[k - 1] = 1.0 * Math.min(maxPts, n - k + 1) / maxPts;

		for (int i = k - 2; i >= 0; --i) {
			int prev = i + 1;
			f[i] = f[prev] + (f[prev] / maxPts) - (f[prev + maxPts] / maxPts);
		}
		return f[0];
	}

}
