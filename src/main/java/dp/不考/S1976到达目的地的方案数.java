package dp.不考;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 图 BFS【min】 DFS
 */
public class S1976到达目的地的方案数 {

	int MOD = (int) Math.pow(10, 9) + 7;
	final long INF = (Long.MAX_VALUE >> 1) - (long) 1e5;
	public int countPaths(int n, int[][] roads) {
		return dijkstra(n, buildGraph(n, roads));
	}

	int dijkstra(int n , List<int[]>[] graph) {
		//维护到达某个点的最短路径
		long[] timeTo = new long[n];
		Arrays.fill(timeTo, INF);
		timeTo[0] = 0;
		//到达某个点的路线数量
		int[] countTo = new int[n];
		countTo[0] = 1;
		PriorityQueue<State> queue = new PriorityQueue<>((o1, o2) -> {
			return Long.compare(o1.timeFromStart, o2.timeFromStart);
		});
		queue.offer(new State(0, 0));
		while(!queue.isEmpty()) {
			State curState = queue.poll();
			int curNode = curState.node;
			long curTimeFromStart = curState.timeFromStart;
			if(curTimeFromStart > timeTo[curNode]) continue;
			for(int[] next : graph[curNode]) {
				int nextNode = next[0];
				long nextTimeFromStart = next[1] + timeTo[curNode];
				if(nextTimeFromStart < timeTo[nextNode]) {
					//维护最短路数组
					timeTo[nextNode] = nextTimeFromStart;
					//维护到达该点的路线数量
					countTo[nextNode] = countTo[curNode];
					queue.offer(new State(nextNode, nextTimeFromStart));
				}
				//如果多条最短路
				else if(nextTimeFromStart == timeTo[nextNode]) {
					countTo[nextNode] = (countTo[nextNode] + countTo[curNode]) % MOD;
				}
			}
		}
		return countTo[n-1];
	}

	List<int[]>[] buildGraph(int n, int[][] roads) {
		List<int[]>[] graph = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			graph[i] = new LinkedList<>();
		}
		for(int[] edge : roads) {
			int u = edge[0];
			int v = edge[1];
			int time = edge[2];
			graph[u].add(new int[]{v, time});
			graph[v].add(new int[]{u, time});
		}
		return graph;
	}

}
class State {
	int node;
	long timeFromStart;

	public State(int node, long timeFromStart) {
		this.node = node;
		this.timeFromStart = timeFromStart;
	}
}