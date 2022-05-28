package 依赖前一个状态.矩阵.正方形子矩阵;

/**
 * 依赖前面累计状态 分别计算向右 向下的累计连续1的个数，以便后序快速判断。
 * i,j,0 横向累加，i,j,1 纵向累加
 */
public class S1139最大的以1为边界的正方形 {

	public int largest1BorderedSquare(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][][] f = new int[n + 1][m + 1][2];
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				if (grid[i - 1][j - 1] == 1) {
					f[i][j][0] = f[i][j - 1][0] + 1;
					f[i][j][1] = f[i - 1][j][1] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				int k = Math.min(f[i][j][0], f[i][j][1]);
				if (k <= max) {
					continue;
				}
				while (k > max) {
					if (f[i][j - k + 1][1] >= k && f[i - k + 1][j][0] >= k) {
						max = k;
						break;
					}
					k--;
				}
			}
		}
		return max * max;
	}

}
