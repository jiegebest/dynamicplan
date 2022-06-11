package dp.依赖前一个状态99.区间13;

import java.util.Arrays;

/**
 * 子规模是一个区间，区间规划
 * 有子规模
 * 如果确定一条边，第三点选择邻接点，n 就缩小 1  sum + f[n-1]
 * 如果确定一条边，第三点不选择邻接点，两部分的最优解的组合， sum + f[k] + f[n + 1 - k]
 * n 从1推到 n
 * 初始化 max，取min
 * 选择任意一条边，去看所有情况
 * 可以选择开头和结尾，再取中间任意一条边。这样去算
 * f[i]代表values的前几个元素
 * 区间范围逐渐放大，从 3个到 n 个
 */
public class S1039多边形三角剖分的最低得分 {

	public int minScoreTriangulation(int[] values) {
		int n = values.length;
		int[][] f = new int[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(f[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < n; ++i) {
			f[i][i] = 0;
		}
		for (int i = 0; i + 1 < n; ++i) {
			f[i][i + 1] = 0;
		}

		for (int i = n - 3; i >= 0; --i) {
			for (int j = i + 2; j < n; ++j) {
				int temp = values[i] * values[j];
				f[i][j] = Math.min(f[i][j], (temp * values[i + 1]) + f[i + 1][j]);
				for (int k = i + 2; k < j - 1; ++k) {
					f[i][j] = Math.min(f[i][j], (temp * values[k]) + f[i][k] + f[k][j]);
				}
				f[i][j] = Math.min(f[i][j], (temp * values[j - 1]) + f[i][j - 1]);
			}
		}

		return f[0][n - 1];
	}

}
