package dp.依赖前一个状态99.过程模拟1;

import java.util.Arrays;

/**
 中转次数 <= k 相当于移动次数<=k+1
 0 <= from,to < 100
 f[i][j] 次数为 i，终点为 j，的最低价格
 */
public class S787K站中转内最便宜的航班 {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		++k;
		int[][] f = new int[101][101];
		for (int i = 0; i <= k; ++i) {
			Arrays.fill(f[i], Integer.MAX_VALUE);
			f[i][src] = 0;
		}

		for (int i = 1; i <= k; ++i) {
			for (int[] flight : flights) {
				int start = flight[0];
				int end = flight[1];
				if (src == start || f[i - 1][start] != Integer.MAX_VALUE) {
					f[i][end] = Math.min(f[i][end], f[i - 1][start] + flight[2]);
				}
			}
		}

		int minCost = Integer.MAX_VALUE;
		for (int i = 1; i <= k; ++i) {
			minCost = Math.min(minCost, f[i][dst]);
		}
		return minCost == Integer.MAX_VALUE ? -1 : minCost;
	}

}
