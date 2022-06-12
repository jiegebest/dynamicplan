package dp.依赖后面的状态;

public class S983最低票价 {

	public int mincostTickets(int[] days, int[] costs) {
		int n = days.length, src = days[n - 1], dest = days[0];
		int[] f = new int[src + 31];
		int d = n - 1;
		for (int i = src; i >= dest; --i) {
			if (i == days[d]) {
				f[i] = Math.min(costs[0] + f[i + 1], Math.min(costs[1] + f[i + 7], costs[2] + f[i + 30]));
				--d;
			} else {
				f[i] = f[i + 1];
			}
		}
		return f[dest];
	}

}
