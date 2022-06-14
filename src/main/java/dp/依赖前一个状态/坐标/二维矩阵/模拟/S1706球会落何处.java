package dp.依赖前一个状态.坐标.二维矩阵.模拟;

import java.util.Arrays;

public class S1706球会落何处 {

	public int[] findBall(int[][] grid) {
		int m = grid.length + 1, n = grid[0].length;
		int[][] f = new int[m][n];
		for (int j = 0; j < n; ++j) {
			f[0][j] = j;
		}
		for (int i = 1; i < m; ++i) {
			Arrays.fill(f[i], -1);
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (j > 0 && grid[i - 1][j] == 1 && grid[i - 1][j - 1] == 1) {
					f[i][j] = f[i - 1][j - 1];
				} else if (j < n - 1 && grid[i - 1][j] == -1 && grid[i - 1][j + 1] == -1) {
					f[i][j] = f[i - 1][j + 1];
				}
			}
		}

		int[] arr = new int[n];
		Arrays.fill(arr, -1);
		for (int j = 0; j < n; ++j) {
			int index = f[m - 1][j];
			if (index != -1) {
				// 意思就是我从 index 位置走到 j 了，index 索引保存目标位置 j 的值
				arr[index] = j;
			}
		}
		return arr;
	}

}
