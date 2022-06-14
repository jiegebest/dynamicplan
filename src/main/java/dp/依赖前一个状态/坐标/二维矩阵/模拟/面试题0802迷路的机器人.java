package dp.依赖前一个状态.坐标.二维矩阵.模拟;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 面试题0802迷路的机器人 {

	public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] == 1) {
			return new ArrayList<>();
		}

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		boolean[][] f = new boolean[m][n];
		f[0][0] = true;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (obstacleGrid[i][j] == 0) {
					if (i > 0 && obstacleGrid[i - 1][j] == 0 && f[i - 1][j]) {
						f[i][j] = true;
					} else if (j > 0 && obstacleGrid[i][j - 1] == 0 && f[i][j - 1]) {
						f[i][j] = true;
					}
				}
			}
		}

		List<List<Integer>> paths = new ArrayList<>();
		if (!f[m - 1][n - 1]) {
			return paths;
		}

		int i = m - 1, j = n - 1;
		List<Integer> path = new ArrayList<>();
		path.add(i);
		path.add(j);
		paths.add(path);

		while (i > 0 || j > 0) {
			path = new ArrayList<>();
			if (i > 0 && f[i - 1][j]) {
				--i;
			} else if (j > 0 && f[i][j - 1]) {
				--j;
			}
			path.add(i);
			path.add(j);
			paths.add(path);
		}
		Collections.reverse(paths);
		return paths;
	}
}
