package dp.依赖前一个状态.状态机.左右4;

import java.util.ArrayList;
import java.util.List;

/**
 * 距离是取两边最小值
 * 预处理左边和右边即可
 *
 * 到左边各个颜色的最小距离
 * 到右边各个颜色的最小距离
 */
public class S1182与目标颜色间的最短距离 {

	public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
		int INF = Integer.MAX_VALUE / 2;
		int n = colors.length;

		int[][] f = new int[n][4];
		int leftOne = INF, leftTwo = INF, leftThree = INF;
		for (int i = 0; i < n; ++i) {
			if (colors[i] == 1) {
				leftOne = i;
			} else if (colors[i] == 2) {
				leftTwo = i;
			} else {
				leftThree = i;
			}
			f[i][1] = leftOne == INF ? INF : i - leftOne;
			f[i][2] = leftTwo == INF ? INF : i - leftTwo;
			f[i][3] = leftThree == INF ? INF : i - leftThree;
		}

		int[][] g = new int[n][4];
		int rightOne = INF, rightTwo = INF, rightThree = INF;
		for (int i = n - 1; i >= 0; --i) {
			if (colors[i] == 1) {
				rightOne = i;
			} else if (colors[i] == 2) {
				rightTwo = i;
			} else {
				rightThree = i;
			}
			g[i][1] = rightOne == INF ? INF : rightOne - i;
			g[i][2] = rightTwo == INF ? INF : rightTwo - i;
			g[i][3] = rightThree == INF ? INF : rightThree - i;
		}

		List<Integer> res = new ArrayList<>();
		for (int[] query : queries) {
			int i = query[0];
			int j = query[1];
			int min = Math.min(f[i][j], g[i][j]);
			res.add(min == INF ? -1 : min);
		}
		return res;
	}

}
