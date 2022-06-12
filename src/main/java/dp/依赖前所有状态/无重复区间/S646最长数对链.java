package dp.依赖前所有状态.无重复区间;

import java.util.Arrays;

/**
 * 尾数排序，尾数相同，按照头一个数排序。
 * f[i] 代表以 i 数对结尾最长长度
 * 所有域的最长长度的 max
 */
public class S646最长数对链 {

	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

		int n = pairs.length;
		int[] f = new int[n];
		Arrays.fill(f, 1);

		int max = 1;
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (pairs[j][1] < pairs[i][0]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
			max = Math.max(max, f[i]);
		}
		return max;
	}

}
