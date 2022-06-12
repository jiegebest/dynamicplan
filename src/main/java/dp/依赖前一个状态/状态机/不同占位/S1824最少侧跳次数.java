package dp.依赖前一个状态.状态机.不同占位;

import java.util.Arrays;

/**
 * 状态机
 * 0-1-2-3
 *  最少侧跳次数
 *  只依赖前一项
 *
 *  先往前推进 > 后纵向跳跃
 */
public class S1824最少侧跳次数 {

	public int minSideJumps(int[] obstacles) {
		int INF = Integer.MAX_VALUE / 2;
		int n = obstacles.length;
		int[][] f = new int[n][3];
		for (int i = 1; i < n; ++i) {
			Arrays.fill(f[i], INF);
		}
		f[0][1] = 0;
		f[0][0] = f[0][2] = 1;

		for (int i = 1; i < n; ++i) {
			if (obstacles[i] != 1) {
				f[i][0] = f[i - 1][0];
			}
			if (obstacles[i] != 2) {
				f[i][1] = f[i - 1][1];
			}
			if (obstacles[i] != 3) {
				f[i][2] = f[i - 1][2];
			}
			if (obstacles[i] != 1) {
				f[i][0] = Math.min(f[i][0], Math.min(f[i][1], f[i][2]) + 1);
			}
			if (obstacles[i] != 2) {
				f[i][1] = Math.min(f[i][1], Math.min(f[i][0], f[i][2]) + 1);
			}
			if (obstacles[i] != 3) {
				f[i][2] = Math.min(f[i][2], Math.min(f[i][0], f[i][1]) + 1);
			}
		}

		return Math.min(f[n - 1][0], Math.min(f[n - 1][1], f[n - 1][2]));
	}

}
