package dp.依赖前一个状态.状态机.左右4;

/**
 * 二刷
 *
 这道题因为不是全部拿完，所以不适合用区间规划去做，而是用状态机，左右规划
 左边拿 i 个，右边拿 j 个，第 i+j-1步

 f[i][j] = Math.max(
 f[i + 1][j] + multipliers[i + j - 1] * nums[i],
 f[i][j - 1] + multipliers[i + j - 1] * nums[n - j]
 );

 全左 f[i][0] = f[i - 1][0] + multipliers[i] * nums[i]
 全右 f[0][i] = f[0][i - 1] + multipliers[i] * nums[n - i]

 multipliers是从 0 开始的
 */
public class S1770执行乘法运算的最大分数 {

	public int maximumScore(int[] nums, int[] multipliers) {
		int n = nums.length;
		int m = multipliers.length;
		int[][] f = new int[m + 1][m + 1];
		// 全部拿左边，全部拿右边
		for (int i = 1; i <= m; ++i) {
			f[i][0] = f[i - 1][0] + multipliers[i - 1] * nums[i - 1];
			f[0][i] = f[0][i - 1] + multipliers[i - 1] * nums[n - i];
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 1; i + j <= m; ++j) {
				f[i][j] = Math.max(
						f[i - 1][j] + multipliers[i + j - 1] * nums[i - 1],
						f[i][j - 1] + multipliers[i + j - 1] * nums[n - j]
				);
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= m; ++i) {
			max = Math.max(max, f[i][m - i]);
		}
		return max;
	}

}
