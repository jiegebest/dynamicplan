package dp.依赖前一个状态.前缀.划分;

/**
 * 最多 k 组
 * 非空子数组,分数由每个子数组内的平均值(区间和/个数)的总和构成
 * 区间和=前缀和之差
 */
public class S813最大平均值和的分组 {

	public double largestSumOfAverages(int[] nums, int k) {
		int n = nums.length;
		double[][] f = new double[n + 1][k + 1];
		double[] prefixSum = new double[n + 1];
		for (int i = 1; i <= n; ++i) {
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
			f[i][1] = prefixSum[i] / i;
		}

		for (int i = 2; i <= n; ++i) {
			// 最后一组多长
			for (int j = 1; j <= Math.min(i, k); ++j) {
				for (int prev = j - 1; prev < i; ++prev) {
					double avg = (prefixSum[i] - prefixSum[prev]) / (i - prev);
					f[i][j] = Math.max(f[i][j], f[prev][j - 1] + avg);
				}
			}
		}

		return f[n][k];
	}

}
