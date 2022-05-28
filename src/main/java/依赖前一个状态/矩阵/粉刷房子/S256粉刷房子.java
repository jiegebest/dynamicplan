package 依赖前一个状态.矩阵.粉刷房子;

/**
 * 三色
 */
public class S256粉刷房子 {

	public int minCost(int[][] costs) {
		int n = costs.length;
		int m = costs[0].length;
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				int prev = Integer.MAX_VALUE;
				for (int k = 0; k < m; ++k) {
					if (j != k) {
						prev = Math.min(prev, costs[i - 1][k]);
					}
				}
				costs[i][j] += prev;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int cost : costs[n - 1]) {
			min = Math.min(min, cost);
		}
		return min;
	}

}
