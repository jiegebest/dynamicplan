package 依赖前一个状态.矩阵.路径和路径数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 可行性 boolean 返回一条可行的路径
 */
public class 面试题0802迷路的机器人 {

	public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
		List<List<Integer>> paths = new ArrayList<>();
		if (obstacleGrid[0][0] == 1) {
			return paths;
		}

		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		boolean[][] f = new boolean[n][m];
		f[0][0] = true;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (obstacleGrid[i][j] == 0) {
					if (i > 0 && f[i - 1][j] && obstacleGrid[i - 1][j] != 1) {
						f[i][j] = true;
					}
					if (j > 0 && f[i][j - 1] && obstacleGrid[i][j - 1] != 1) {
						f[i][j] = true;
					}
				}
			}
		}

		if (!f[n - 1][m - 1]) {
			return paths;
		}

		int i = n - 1, j = m - 1;
		List<Integer> path = new ArrayList();
		path.add(i);
		path.add(j);
		paths.add(path);
		while (i > 0 || j > 0) {
			path = new ArrayList();
			if (i > 0 && f[i - 1][j]) {
				path.add(i-- - 1);
				path.add(j);
			} else if (j > 0 && f[i][j - 1]) {
				path.add(i);
				path.add(j-- - 1);
			}
			paths.add(path);
		}
		Collections.reverse(paths);
		return paths;
	}
}
