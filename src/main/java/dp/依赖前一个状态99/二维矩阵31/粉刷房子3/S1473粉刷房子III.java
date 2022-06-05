package dp.依赖前一个状态99.二维矩阵31.粉刷房子3;

import java.util.Arrays;

/**
 * 略过
 * 相邻房子可以同色。同色即为同街区 约束规划 01背包
 * f i,j,k 索引为i的房子，最新涂色是j（对于街区的计算有帮助），目前的街区数是k
 * houses 0~h-1
 * color  1~m
 * target 1~target
 */
public class S1473粉刷房子III {

	static final int INF = Integer.MAX_VALUE / 2;

	public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
		int[][][] f = new int[m][n + 1][target + 1];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j <= n; ++j) {
				Arrays.fill(f[i][j], INF);
			}
		}
		if (houses[0] == 0) {
			for (int j = 1; j <= n; ++j) {
				f[0][j][1] = cost[0][j - 1];
			}
		} else {
			f[0][houses[0]][1] = -1;
		}

		for (int i = 1; i < m; ++i) {
			int c = houses[i];
			if (c == 0) {
				for (int j = 1; j <= n; ++j) {
					for (int k = 1; k <= target; ++k) {
						int prev = f[i - 1][j][k];
						if (prev == INF) {
							continue;
						}
						prev = prev == -1 ? 0 : prev;
						for (int J = 1; J <= n; ++j) {
							if (j == J) {
								f[i][J][k] = Math.min(f[i][J][k], prev + cost[i][J - 1]);
							} else if (k + 1 <= target) {
								f[i][J][k + 1] = Math.min(f[i][J][k + 1], prev + cost[i][J - 1]);
							}
						}
					}
				}
			} else {
				for (int j = 1; j <= n; ++j) {
					for (int k = 1; k <= target; ++k) {
						if (j == c) {
							f[i][c][k] = Math.min(f[i][c][k], f[i - 1][j][k]);
						} else if (k + 1 <= target) {
							f[i][c][k + 1] = Math.min(f[i][c][k + 1], f[i - 1][j][k]);
						}
					}
				}
			}
		}

		int ans = INF;
		for (int j = 1; j <= n; ++j) {
			ans = Math.min(ans, f[m - 1][j][target]);
		}
		if (ans == INF) {
			return -1;
		}
		return ans == -1 ? 0 : ans;
	}

}
