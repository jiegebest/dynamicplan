package dp.依赖前一个状态.区间;

/**
 如果有多个这样的城市，则返回编号最大的城市
 f[i][j] i 第 i 步，j 目标
 f[i][dest] = f[i - 1][src] + weight
 距离相当于步数

 相当于 m 个状态向下转化

 无向

 返回能通过某些路径到达其他城市数目最少、且路径距离最大为 distanceThreshold 的城市。
 其实就是说有一个距离上限，在这个范围内，目的是说，找到最短路径。能够到达其它城市的数目最少。
 需要计算起点和终点之间的最短权重
 ij 之间距离怎么计算呢？直接到达或者间接到达。
 再去计算到达的权重是否在指定范围内，取 count，count 最后表示在最小，如果 count 相同，取 i 最小。
 */
public class S1334阈值距离内邻居最少的城市 {

	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		// 初始化无向图数据结构
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				graph[i][j] = Integer.MAX_VALUE;
			}
		}
		// 找到直接距离
		for (int[] arr : edges) {
			graph[arr[0]][arr[1]] = graph[arr[1]][arr[0]] = arr[2];
		}
		// 找到间接距离
		for (int k = 0; k < n; ++k) {
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (i != k && graph[i][k] != Integer.MAX_VALUE && k != j && graph[k][j] != Integer.MAX_VALUE) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}
		}

		// 找i 能到其它位置的最小数目，如果最小数目相同，取较小的那个 i
		int min = n, src = n;
		for (int i = 0; i < n; ++i) {
			int cnt = 0;
			for (int j = 0; j < n; ++j) {
				if (i != j && graph[i][j] <= distanceThreshold) {
					++cnt;
				}
			}
			// 如果有多个这样的城市，则返回编号最大的城市
			if (cnt <= min) {
				min = cnt;
				src = i;
			}
		}
		return src;
	}

}
