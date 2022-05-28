package 依赖前一个状态.矩阵.正方形子矩阵;

import java.util.HashMap;
import java.util.Map;

/**
 * 四个角为1的矩形
 * 每行记录 =1的i,j坐标pos到map中，后面行如果发现有，就加计数，并放入map中
 */
public class S750角矩形的数量 {

	public int countCornerRectangles(int[][] grid) {
		Map<Integer, Integer> map = new HashMap<>();
		int cnt = 0, m = grid[0].length;
		for (int[] row : grid) {
			for (int i = 0; i < m; ++i) {
				if (row[i] == 0) {
					continue;
				}
				for (int j = i + 1; j < m; ++j) {
					if (row[j] == 0) {
						continue;
					}
					int pos = i * 200 + j;
					int times = map.getOrDefault(pos, 0);
					cnt += times;
					map.put(pos, times + 1);
				}
			}
		}
		return cnt;
	}

}
