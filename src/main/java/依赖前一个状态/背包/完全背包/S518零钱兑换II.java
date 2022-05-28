package 依赖前一个状态.背包.完全背包;

public class S518零钱兑换II {
	// f[i] 表示金额之和等于 i 的硬币组合数
	public int change(int amount, int[] coins) {
		int[] f = new int[amount + 1];
		f[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= amount; ++i) {
				f[i] += f[i - coin];
			}
		}
		return f[amount];
	}

}
