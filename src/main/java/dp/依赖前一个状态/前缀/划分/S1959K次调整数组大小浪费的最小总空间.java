package dp.依赖前一个状态.前缀.划分;

import java.util.Arrays;

/**
 * 能够套在划分的题型上
 * f[i][j] 前 i 个元素划分成 j 组的最少浪费空间
 * 考虑最后一组分几个元素的所有可能
 * f[i][j - 1] 往前走，保留最大值，保留计数
 * 往前搜索到前 j-1个元素
 *
 * 预处理任意区间的权值 = max * len - sum
 * 任意区间最大值？区间规划
 * waste 任意区间的调整代价
 * t 代表最后一组的起始位置
 */
public class S1959K次调整数组大小浪费的最小总空间 {

	public int minSpaceWastedKResizing(int[] nums, int k) {
		int n = nums.length;

		int[] preSum = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			preSum[i] = preSum[i - 1] + nums[i - 1];
		}

		int[][] max = new int[n][n];
		for (int i = n - 1; i >= 0; --i) {
			for (int j = i; j < n; ++j) {
				if (i == j) {
					max[i][j] = nums[j];
				} else {
					max[i][j] = Math.max(max[i][j - 1], nums[j]);
				}
			}
		}

		int[][] waste = new int[n][n];
		for (int i = n - 1; i >= 0; --i) {
			for (int j = i; j < n; ++j) {
				if (i == j) {
					waste[i][j] = 0;
				} else {
					waste[i][j] = (j - i + 1) * max[i][j] - (preSum[j + 1] - preSum[i]);
				}
			}
		}

		int[][] f = new int[n + 1][k + 1];
		for (int i = 1; i <= n; ++i) {
			Arrays.fill(f[i], Integer.MAX_VALUE);
		}
		for (int i = 1; i <= n; ++i) {
			for (int j = 0; j <= k; ++j) {
				if (j == 0) {
					f[i][0] = waste[0][i - 1];
				} else {
					for (int t = i; t > 0; --t) {
						f[i][j] = Math.min(f[i][j], f[t - 1][j - 1] + waste[t - 1][i - 1]);
					}
				}
			}
		}
		return f[n][k];
	}

}
