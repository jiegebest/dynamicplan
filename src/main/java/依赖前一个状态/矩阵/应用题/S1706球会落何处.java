package 依赖前一个状态.矩阵.应用题;

import java.util.Arrays;

public class S1706球会落何处 {

	/**
	 矩阵经典解法，递推
	 */
	public int[] findBall(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		int[][] f = new int[n + 1][m];
		for (int j = 0; j < m; ++j) {
			f[0][j] = j;
		}
		for (int i = 1; i <= n; ++i) {
			Arrays.fill(f[i], -1);
		}

		for (int i = 1; i <= n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (j > 0 && grid[i - 1][j - 1] == 1 && grid[i - 1][j] == 1) {
					f[i][j] = f[i - 1][j - 1];
				} else if (j < m - 1 && grid[i - 1][j + 1] == -1 && grid[i - 1][j] == -1) {
					f[i][j] = f[i - 1][j + 1];
				}
			}
		}

		int[] arr = new int[m];
		Arrays.fill(arr, -1);
		for (int j = 0; j < m; ++j) {
			if (f[n][j] != -1) {
				arr[f[n][j]] = j;
			}
		}
		return arr;
	}

}
