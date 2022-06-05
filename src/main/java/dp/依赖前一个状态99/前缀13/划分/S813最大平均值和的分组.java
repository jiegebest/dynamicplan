package dp.依赖前一个状态99.前缀13.划分;

/**
 * 很经典
 */
public class S813最大平均值和的分组 {

	public double largestSumOfAverages(int[] nums, int k) {
		int n = nums.length;
		double[][] f = new double[n + 1][k + 1];
		double[] preSum = new double[n + 1];
		for (int i = 1; i <= n; ++i) {
			preSum[i] = preSum[i - 1] + nums[i - 1];
			f[i][1] = preSum[i] / i;
		}

		for (int i = 2; i <= n; ++i) {
			for (int j = 2; j <= Math.min(i, k); ++j) {
				for (int p = j - 1; p < i; ++p) {
					f[i][j] = Math.max(f[i][j], f[p][j - 1] + (preSum[i] - preSum[p]) / (i - p));
				}
			}
		}
		return f[n][k];
	}

}
