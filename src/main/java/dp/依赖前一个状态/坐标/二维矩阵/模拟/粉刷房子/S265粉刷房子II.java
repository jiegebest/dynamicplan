package dp.依赖前一个状态.坐标.二维矩阵.模拟.粉刷房子;

public class S265粉刷房子II {

	public int minCostII(int[][] costs) {
		int m = costs.length, n = costs[0].length;
		for (int i = 1; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				costs[i][j] += getMinCost(costs[i - 1], j);
			}
		}
		return getMinCost(costs[m - 1], -1);
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
