package memosearch.dfs.排列组合;

import java.util.Arrays;

/**
 * 整四条边，按照数组索引往上添加，每条边不能添加过头，最终看能不能添加完毕
 * 为了减少搜索量，需要对火柴长度从大到小进行排序。
 */
public class S473火柴拼正方形 {

	public boolean makesquare(int[] matchsticks) {
		int sum = 0, max = 0;
		for (int num : matchsticks) {
			sum += num;
			max = Math.max(max, num);
		}
		int len = sum / 4;
		if (sum % 4 != 0 && max > len) {
			return false;
		}

		Arrays.sort(matchsticks);
		for (int i = 0, j = matchsticks.length - 1; i < j; ++i, --j) {
			int temp = matchsticks[i];
			matchsticks[i] = matchsticks[j];
			matchsticks[j] = temp;
		}

		return backtrack(matchsticks, 0, new int[4], len);
	}

	public boolean backtrack(int[] matchsticks, int index, int[] edges, int len) {
		if (index == matchsticks.length) {
			return true;
		}
		for (int i = 0; i < edges.length; ++i) {
			edges[i] += matchsticks[index];
			if (edges[i] <= len && backtrack(matchsticks, index + 1, edges, len)) {
				return true;
			}
			edges[i] -= matchsticks[index];
		}
		return false;
	}

}












