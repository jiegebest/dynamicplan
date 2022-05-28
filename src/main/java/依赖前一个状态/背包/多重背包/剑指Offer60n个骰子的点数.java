package 依赖前一个状态.背包.多重背包;

/**
 * 背包问题 (6种面值)可以用n次，组成1~6n的次数
 */
public class 剑指Offer60n个骰子的点数 {

	public double[] dicesProbability(int n) {
		int m = 6 * n;
		int[][] f = new int[n + 1][m + 1];
		for (int i = 1; i <= 6; ++i) {
			f[1][i] = 1;
		}

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				f[i][j] = f[i][j - 1] + f[i - 1][j - 1];
				if (j - 7 >= 1) {
					f[i][j] -= f[i - 1][j - 7];
				}
			}
		}

		int total = 0;
		for (int j = n; j <= m; ++j) {
			total += f[n][j];
		}

		double[] arr = new double[m - n + 1];
		for (int j = n; j <= m; ++j) {
			arr[j - n] = 1.0 * f[n][j] / total;
		}
		return arr;
	}

}
