package dp.不考;

import java.util.*;

public class S1786从第一个节点出发到最后一个节点的受限路径数 {

	int mod = 1000000007;

	public int countRestrictedPaths(int n, int[][] es) {
		// 预处理所有的边权。 a b w -> a : { b : w } + b : { a : w }
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int[] e : es) {
			int a = e[0], b = e[1], w = e[2];
			Map<Integer, Integer> am = map.getOrDefault(a, new HashMap<Integer, Integer>());
			am.put(b, w);
			map.put(a, am);
			Map<Integer, Integer> bm = map.getOrDefault(b, new HashMap<Integer, Integer>());
			bm.put(a, w);
			map.put(b, bm);
		}

		// 堆优化 Dijkstra：求 每个点 到 第n个点 的最短路
		int[] dist = new int[n + 1];
		boolean[] st = new boolean[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[n] = 0;
		Queue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]); // 点编号，点距离。根据点距离从小到大
		q.add(new int[]{n, 0});
		while (!q.isEmpty()) {
			int[] e = q.poll();
			int idx = e[0], cur = e[1];
			if (st[idx]) continue;
			st[idx] = true;
			Map<Integer, Integer> mm = map.get(idx);
			if (mm == null) continue;
			for (int i : mm.keySet()) {
				dist[i] = Math.min(dist[i], dist[idx] + mm.get(i));
				q.add(new int[]{i, dist[i]});
			}
		}

		// dp 过程
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) arr[i] = new int[]{i + 1, dist[i + 1]}; // 点编号，点距离
		Arrays.sort(arr, (a, b) -> a[1] - b[1]); // 根据点距离从小到大排序

		// 定义 f(i) 为从第 i 个点到结尾的受限路径数量
		// 从 f[n] 递推到 f[1]
		int[] f = new int[n + 1];
		f[n] = 1;
		for (int i = 0; i < n; i++) {
			int idx = arr[i][0], cur = arr[i][1];
			Map<Integer, Integer> mm = map.get(idx);
			if (mm == null) continue;
			for (int next : mm.keySet()) {
				if (cur > dist[next]) {
					f[idx] += f[next];
					f[idx] %= mod;
				}
			}
			// 第 1 个节点不一定是距离第 n 个节点最远的点，但我们只需要 f[1]，可以直接跳出循环
			if (idx == 1) break;
		}
		return f[1];
	}

}
