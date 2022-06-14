package dp.依赖前一个状态.坐标.一维数组.前面保留一个数值;

import java.util.Arrays;

/**
 * 关键点：最多只能取两个区间。因此我们只需要搞清楚任意两个区间之间的关系即可。
 * 一个区间的终点和另一个区间的起点有关系，这个起点要在另一个终点的后面。并且会取前后两个区间的价值之和
 * 因此遇到起点，统计两个区间的价值之和。遇到终点，更新单区间最大值。
 * 因此，起点和终点要拎出来排序
 *
 * 走到起点，看之前最大的区间和当前起点起的长度之和
 * 走到终点，更新最大的区间
 */
public class S2054两个最好的不重叠活动 {

	public int maxTwoEvents(int[][] events) {
		int n = events.length;
		int[][] f = new int[n * 2][3];
		int j = 0;
		for (int i = 0; i < n; ++i) {
			f[j++] = new int[]{events[i][0], 0, events[i][2]};
			f[j++] = new int[]{events[i][1], 1, events[i][2]};
		}
		Arrays.sort(f, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		int max = 0, preMax = 0;
		for (int i = 0; i < n * 2; ++i) {
			if (f[i][1] == 0) {
				max = Math.max(max, preMax + f[i][2]);
			} else {
				preMax = Math.max(preMax, f[i][2]);
			}
		}
		return max;
	}

}
