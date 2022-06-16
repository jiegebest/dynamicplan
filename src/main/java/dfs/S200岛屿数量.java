package dfs;

public class S200岛屿数量 {

	int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public int numIslands(char[][] grid) {
		int cnt = 0, m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == '1') {
					++cnt;
					dfs(grid, m, n, i, j);
				}
			}
		}
		return cnt;
	}

	public void dfs(char[][] grid, int m, int n, int i, int j) {
		if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		for (int k = 0; k < 4; ++k) {
			dfs(grid, m, n, i + dirs[k][0], j + dirs[k][1]);
		}
	}

}
