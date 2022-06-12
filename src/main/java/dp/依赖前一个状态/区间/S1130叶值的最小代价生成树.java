package dp.依赖前一个状态.区间;

import java.util.Arrays;

/**
 * 左右挨着的结合 > 【依赖是左右】 > 因此想到用区间
 * 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积，因此需要跟踪区间的最大值 g[i][j]
 * f[i][j] 区间上的最小非叶子节点总和，需要暴搜所有的可能性
 * i<=k<j
 * f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + g[i][k] * g[k + 1][j])
 * f[i][i] = 0 (如果一个节点有 0 个子节点，那么该节点为叶节点。)
 */
public class S1130叶值的最小代价生成树 {

	public int mctFromLeafValues(int[] arr) {
		int n = arr.length;
		int[][] f = new int[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(f[i], Integer.MAX_VALUE);
		}
		int[][] g = new int[n][n];

		for (int i = n - 1; i >= 0; --i) {
			for (int j = i; j < n; ++j) {
				if (i == j) {
					g[i][j] = arr[i];
					f[i][j] = 0;
				} else {
					g[i][j] = Math.max(g[i][j - 1], arr[j]);
					for (int k = i; k < j; ++k) {
						f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + g[i][k] * g[k + 1][j]);
					}
				}
			}
		}
		return f[0][n - 1];
	}

}
