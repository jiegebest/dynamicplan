package 依赖前一个状态.背包.完全背包;

import java.util.Arrays;

public class S322零钱兑换 {

	public int coinChange(int[] coins, int amount) {
		int[] f = new int[amount + 1];
		Arrays.fill(f, amount + 1);
		f[0] = 0;

		for (int i = 1; i <= amount; ++i) {
			for (int coin : coins) {
				if (coin <= i) {
					f[i] = Math.min(f[i], f[i - coin] + 1);
				}
			}
		}

		return f[amount] > amount ? -1 : f[amount];
	}

}
