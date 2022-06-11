package dp.依赖后特定状态;

/**
 * start=0收集后面的概率，求总和。所以是依赖后面，从后往前求。
 * f[i] 和 f[i + 1] 中间有 9 次重复，干掉。
 */
public class S837新21点 {

	public double new21Game(int n, int k, int maxPts) {
		if (k == 0) {
			return 1.0;
		}

		double[] f = new double[k + maxPts];
		for (int i = k; i <= n && i < k + maxPts; ++i) {
			f[i] = 1;
		}

		f[k - 1] = 1.0 * Math.min(n - k + 1, maxPts) / maxPts;
		for (int i = k - 2; i >= 0; --i) {
			int j = i + 1;
			f[i] = f[j] + f[j] / maxPts - f[j + maxPts] / maxPts;
		}
		return f[0];
	}

}
