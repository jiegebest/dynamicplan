package 依赖前一个状态.矩阵.粉刷房子;

/**
 * k色
 */
public class S265粉刷房子II {

	public int minCostII(int[][] costs) {
		int n = costs.length;
		int k = costs[0].length;
		int[][] f = new int[n][k];
		for (int j = 0; j < k; ++j) {
			f[0][j] = costs[0][j];
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < k; ++j) {
				f[i][j] = getMinCost(f[i - 1], j) + costs[i][j];
			}
		}

		return getMinCost(f[n - 1], -1);
	}

	public int getMinCost(int[] arr, int except) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; ++i) {
			if (i != except) {
				min = Math.min(min, arr[i]);
			}
		}
		return min;
	}

}
