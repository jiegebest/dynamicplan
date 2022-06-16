package dp.memo.bfs;

import java.util.*;

/**
 * BFS
 * 有可能会转回去，所以需要单独去掉起点
 *
 * 因为可以无限循环(一个环无限的绕)，所以很难控制循环的层数
 * 观察，发现速度每个位置的速度最多为101，所以直接进行所有情况的枚举
 * 设 st[x][y][speed]表示当前(x,y)的速度speed是否有可能
 * 为什么速度最多是101呢?
 * 设点 pos --> h1 --> h2 --> h3;
 * speed(h3) = 1
 + h1 - h2 - o2
 + h2 - h3 - o3
 *           = 1 + h1 - h3 - o2 - o3
 * 依次类推...
 */
public class SLCP45自行车炫技赛场 {

	public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
		int m = terrain.length, n = terrain[0].length;
		int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		boolean[][][] f = new boolean[m][n][102];
		Deque<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{position[0], position[1], 1});
		List<int[]> targets = new ArrayList<>();

		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			for (int[] dir : dirs) {
				int i = pos[0] + dir[0];
				int j = pos[1] + dir[1];
				if (i < 0 || i >= m || j < 0 || j >= n) {
					continue;
				}
				int v = pos[2] + terrain[pos[0]][pos[1]] - terrain[i][j] - obstacle[i][j];
				if (v <= 0 || f[i][j][v]) {
					continue;
				}
				f[i][j][v] = true;
				queue.offer(new int[]{i, j, v});
				if (v == 1 && !(i == position[0] && j == position[1])) {
					targets.add(new int[]{i, j});
				}
			}
		}

		int[][] res = new int[targets.size()][2];
		for (int i = 0; i < targets.size(); ++i) {
			res[i] = targets.get(i);
		}
		Arrays.sort(res, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		return res;
	}

}
