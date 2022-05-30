package 未分类41.已刷;

public class S983最低票价 {

	public int mincostTickets(int[] days, int[] costs) {
		int[] f = new int[400];
		int i = days.length - 1, d = days[i];
		while (i >= 0) {
			if (d == days[i]) {
				f[d] = Math.min(Math.min(costs[0] + f[d + 1], costs[1] + f[d + 7]), costs[2] + f[d + 30]);
				--i;
			} else {
				f[d] = f[d + 1];
			}
			d--;
		}
		return f[days[0]];
	}

}
