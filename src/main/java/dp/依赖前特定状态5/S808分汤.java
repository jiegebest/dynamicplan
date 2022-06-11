package dp.依赖前特定状态5;

import java.util.Arrays;

/**
 * 首先 25 的倍数，应该全部干掉，因为不去掉的话，dp 数组会开的很大，效率影响非常多
 * 依赖四种子规模，把四种子规模加和即可
 */
public class S808分汤 {

	public double soupServings(int n) {
		if (n >= 5000) {
			return 1.0;
		}
		n = n / 25 + (n % 25 == 0 ? 0 : 1);
		int[][] arr = new int[][]{{4, 0}, {3,1}, {2,2}, {1,3}};

		double[][] f = new double[n + 1][n + 1];
		f[0][0] = 0.5;
		for (int i = 1; i <= n; ++i) {
			f[i][0] = 0;
			f[0][i] = 1;
		}

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				for (int k = 0; k < 4; ++k) {
					int x = Math.max(i - arr[k][0], 0);
					int y = Math.max(j - arr[k][1], 0);
					f[i][j] += f[x][y];
				}
				f[i][j] *= 0.25;
			}
		}
		return f[n][n];
	}

}
