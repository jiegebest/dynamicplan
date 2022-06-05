package memosearch.dfs;

/**
 * 第一次不能跳，只有访问过才能跳
 */
public class S351安卓系统手势解锁 {

	public int numberOfPatterns(int m, int n) {
		int[][] skip = new int[10][10];
		skip[1][3] = skip[3][1] = 2;
		skip[1][7] = skip[7][1] = 4;
		skip[3][9] = skip[9][3] = 6;
		skip[7][9] = skip[9][7] = 8;
		skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = 5;
		skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5;

		int res = 0;
		boolean[] visited = new boolean[10];
		for (int i = m; i <= n; i++) {
			// i-1是减掉出发点
			res += dfs(visited, skip, 1, i - 1) * 4;
			res += dfs(visited, skip, 2, i - 1) * 4;
			res += dfs(visited, skip, 5, i - 1);
		}
		return res;
	}

	public int dfs(boolean[] visited, int[][] skip, int curr, int remain) {
		if (remain == 0) {
			return 1;
		}
		int res = 0;
		visited[curr] = true;
		for (int i = 1; i <= 9; i++) {
			int cross = skip[curr][i];
			// 只有没有要跨越的节点或者要跨越的节点被访问过，才能进行跨越。之前已经到达过的点，就不访问了
			if (!visited[i] && (cross == 0 || visited[cross])) {
				res += dfs(visited, skip, i, remain - 1);
			}
		}
		visited[curr] = false;
		return res;
	}

}
