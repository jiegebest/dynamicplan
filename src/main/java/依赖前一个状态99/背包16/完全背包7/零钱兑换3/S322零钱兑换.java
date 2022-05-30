package 依赖前一个状态99.背包16.完全背包7.零钱兑换3;

import java.util.Arrays;

public class S322零钱兑换 {

	public int coinChange(int[] coins, int amount) {
		int m = amount;
		int[] f = new int[m + 1];
		Arrays.fill(f, m + 1);
		f[0] = 0;

		for (int i = 1; i <= m; ++i) {
			for (int coin : coins) {
				if (coin <= i) {
					f[i] = Math.min(f[i], f[i - coin] + 1);
				}
			}
		}
		return f[m] > m ? -1 : f[m];
	}

}
