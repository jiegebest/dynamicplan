package dp.依赖后特定状态;

/**
 * 今天不需要出门，不用买票
 * 今天如果要出门，需要买几天？当前决策依赖后面的数据分布情况，我们需要反向状态推导
 * 「今天买多少，得看后几天怎么安排」，即「前面依赖后面」——从后向前来买
 */
public class S983最低票价 {

	public int mincostTickets(int[] days, int[] costs) {
		int n = days.length;
		int min = days[0], max = days[n - 1];
		int[] f = new int[max + 31];

		for (int i = max, j = n - 1; i >= min; --i) {
			if (i == days[j]) {
				int cost1 = f[i + 1] + costs[0];
				int cost2 = f[i + 7] + costs[1];
				int cost3 = f[i + 30] + costs[2];
				f[i] = Math.min(cost1, Math.min(cost2, cost3));
				--j;
			} else {
				f[i] = f[i + 1];
			}
		}

		return f[min];
	}

}
