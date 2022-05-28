package 依赖前一个状态.矩阵.粉刷房子;

import java.util.Arrays;

public class 剑指OfferII091粉刷房子 {

	public int minCost(int[][] costs) {
		int n = costs.length;
		int[][] f = new int[n][3];
		for (int j = 0; j < 3; ++j) {
			f[0][j] = costs[0][j];
		}
		for (int i = 1; i < n; ++i) {
			Arrays.fill(f[i], Integer.MAX_VALUE);
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < 3; ++j) {
				for (int k = 0; k < 3; ++k) {
					if (j != k) {
						f[i][j] = Math.min(f[i][j], costs[i][j] + f[i - 1][k]);
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int j = 0; j < 3; ++j) {
			min = Math.min(min, f[n - 1][j]);
		}
		return min;
	}

}
