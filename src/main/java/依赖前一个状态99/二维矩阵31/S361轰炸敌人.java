package 依赖前一个状态99.二维矩阵31;

/**
 * 左上角往右下角，统计上面和左面开始的炸弹数量
 * 右下角往左下角，统计右面和下面开始的炸弹数量，并比较出max
 * 每个位置都需要存储上下左右的炸弹数量
 */
public class S361轰炸敌人 {

	public int maxKilledEnemies(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][][] f = new int[n + 2][m + 2][4];

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				int i = y + 1, j = x + 1;
				if (grid[y][x] == '0') {
					f[i][j][0] = f[i][j - 1][0];
					f[i][j][1] = f[i - 1][j][1];
				} else if (grid[y][x] == 'E') {
					f[i][j][0] = f[i][j - 1][0] + 1;
					f[i][j][1] = f[i - 1][j][1] + 1;
				}
			}
		}

		int max = 0;
		for (int y = n - 1; y >= 0; y--) {
			for (int x = m - 1; x >= 0; x--) {
				int i = y + 1, j = x + 1;
				if (grid[y][x] == '0') {
					f[i][j][2] = f[i][j + 1][2];
					f[i][j][3] = f[i + 1][j][3];
					max = Math.max(max, f[i][j][0] + f[i][j][1] + f[i][j][2] + f[i][j][3]);
				} else if (grid[y][x] == 'E') {
					f[i][j][2] = f[i][j + 1][2] + 1;
					f[i][j][3] = f[i + 1][j][3] + 1;
				}
			}
		}
		return max;
	}

}
