package memo.dfs.状压.二进制.必全选集合走索引另一集合走状压;

/**
 * 1 <= n <= m <= 10 状压
 * 每个 bike 跟其他没用过的自行车匹配
 * 自行车的状态state包含了工人的状态wIdx，所以不需要同时保存两个状态
 */
public class S1066校园自行车分配II {

	public int assignBikes(int[][] workers, int[][] bikes) {
		return dp(new int[1 << bikes.length], workers, bikes, 0, 0);
	}

	public int dp(int[] f, int[][] workers, int[][] bikes, int wIdx, int state) {
		if (wIdx == workers.length) {
			return 0;
		}
		if (f[state] != 0) {
			return f[state];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < bikes.length; ++i) {
			if ((state & (1 << i)) == 0) {
				int distance = Math.abs(workers[wIdx][0] - bikes[i][0]) + Math.abs(workers[wIdx][1] - bikes[i][1]);
				int sum = dp(f, workers, bikes, wIdx + 1, state | (1 << i));
				min = Math.min(min, distance + sum);
			}
		}
		f[state] = min;
		return min;
	}

}
