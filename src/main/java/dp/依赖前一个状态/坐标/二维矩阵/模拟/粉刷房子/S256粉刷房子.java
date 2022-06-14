package dp.依赖前一个状态.坐标.二维矩阵.模拟.粉刷房子;

public class S256粉刷房子 {

	public int minCost(int[][] costs) {
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
		for (int j = 0; j < arr.length; ++j) {
			if (j != except) {
				min = Math.min(min, arr[j]);
			}
		}
		return min;
	}

}
