package 依赖前一个状态99.背包16.完全背包7.零钱兑换3;

public class S518零钱兑换II {

	public int change(int amount, int[] coins) {
		int m = amount;
		int[] f = new int[m + 1];
		f[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= m; ++i) {
				f[i] += f[i - coin];
			}
		}
		return f[m];
	}

}
