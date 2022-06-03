package 未分类25;

import java.util.LinkedList;
import java.util.List;

public class SLCP45自行车炫技赛场 {

	int[][] a = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	List<Integer> res = new LinkedList<>();
	int n, m, x, y;
	boolean[][][] help;
	int[][] terrain;
	int[][] obstacle;

	public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
		n = terrain.length;
		m = terrain[0].length;
		x = position[0];
		y = position[1];
		this.terrain = terrain;
		this.obstacle = obstacle;

		help = new boolean[n][m][terrain[x][y] + 1];
		dfs(position, 0);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if ((x != i || y != j) && terrain[x][y] >= terrain[i][j] && help[i][j][terrain[x][y] - terrain[i][j]]) {
					res.add(i * m + j);
				}
			}
		}
		return res.stream().distinct().sorted().map(i -> new int[]{i / m, i % m}).toArray(int[][]::new);
	}

	private void dfs(int[] position, int sum) {
		for (int i = 0; i < 4; ++i) {
			int nextX = position[0] + a[i][0];
			int nextY = position[1] + a[i][1];
			if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
			//到达这个点的路径和 大于 高度差 所以剪枝
			if (sum + obstacle[nextX][nextY] > terrain[x][y] - terrain[nextX][nextY]) continue;
			//记忆化剪枝（主要是全是0）
			if (help[nextX][nextY][sum + obstacle[nextX][nextY]]) continue;
			help[nextX][nextY][sum + obstacle[nextX][nextY]] = true;
			dfs(new int[]{nextX, nextY}, sum + obstacle[nextX][nextY]);
		}
	}

}
