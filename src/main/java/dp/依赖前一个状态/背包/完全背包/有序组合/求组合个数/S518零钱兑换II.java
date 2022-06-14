package dp.依赖前一个状态.背包.完全背包.有序组合.求组合个数;

public class S518零钱兑换II {

	public int change(int amount, int[] coins) {
		int n = amount;
		int[] f = new int[n + 1];
		f[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= n; ++i) {
				f[i] += f[i - coin];
			}
		}
		return f[n];
	}

}
