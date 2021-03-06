package dp.依赖前一个状态.坐标.二维矩阵.正方形.角1矩阵;

import java.util.HashMap;
import java.util.Map;

/**
 * 二刷
 */
public class S750角矩形的数量 {

	public int countCornerRectangles(int[][] grid) {
		int m = grid.length, n = grid[0].length, total = 0;
		Map<Integer, Integer> cache = new HashMap<>();
		for (int r = 0; r < m; ++r) {
			for (int i = 0; i < n - 1; ++i) {
				if (grid[r][i] == 0) {
					continue;
				}
				for (int j = i + 1; j < n; ++j) {
					if (grid[r][j] == 0) {
						continue;
					}
					int pos = i * n + j;
					int cnt = cache.getOrDefault(pos, 0);
					total += cnt;
					cache.put(pos, cnt + 1);
				}
			}
		}
		return total;
	}

}
