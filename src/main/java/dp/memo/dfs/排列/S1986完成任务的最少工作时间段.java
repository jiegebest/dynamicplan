package dp.memo.dfs.排列;

import java.util.Arrays;

/**
 * 缓存状态压缩数组组合，最后一组剩余个数集合需要的最少组数
 */
public class S1986完成任务的最少工作时间段 {

	public int minSessions(int[] tasks, int sessionTime) {
		int n = 1 << tasks.length;
		int[][] cache = new int[n][sessionTime + 1];
		for (int[] arr : cache) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}
		return dfs(tasks, sessionTime, cache, 0, 0, n - 1);
	}

	public int dfs(int[] tasks, int sessionTime, int[][] cache, int bits, int curr, int target) {
		if (cache[bits][curr] != Integer.MAX_VALUE) {
			return cache[bits][curr];
		}
		if (bits == target) {
			return 1;
		}

		int group = Integer.MAX_VALUE;
		for (int i = 0; i < tasks.length; ++i) {
			if (((bits >> i) & 1) == 0) {
				if (curr + tasks[i] <= sessionTime) {
					group = Math.min(group, dfs(tasks, sessionTime, cache, bits | (1 << i), curr + tasks[i], target));
				} else {
					group = Math.min(group, 1 + dfs(tasks, sessionTime, cache, bits | (1 << i), tasks[i], target));
				}
			}
		}
		cache[bits][curr] = group;
		return group;
	}

}









