package 依赖前一个状态.背包.完全背包;

import java.util.Arrays;

public class 剑指OfferII103最少的硬币数目 {

	// 完全背包 只需要考虑最后一个硬币用啥
	public int coinChange(int[] coins, int amount) {
		int max = amount + 1;
		int[] f = new int[max];
		Arrays.fill(f, max);
		f[0] = 0;

		for (int i = 1; i <= amount; ++i) {
			for (int coin : coins) {
				if (coin <= i) {
					f[i] = Math.min(f[i], f[i - coin] + 1);
				}
			}
		}

		return f[amount] == max ? - 1 : f[amount];
	}

}
