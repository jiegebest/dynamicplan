package dp.依赖前一个状态.背包.完全背包.无序组合.求元素个数;

import java.util.Arrays;

/**
 * 完全背包 只需要考虑最后一个硬币用啥
 */
public class 剑指OfferII103最少的硬币数目 {

	public int coinChange(int[] coins, int amount) {
		int m = amount;
		int[] f = new int[amount + 1];
		Arrays.fill(f, m);
		f[0] = 0;

		for (int i = 1; i <= m; ++i) {
			for (int coin : coins) {
				if (coin <= i) {
					f[i] = Math.min(f[i], f[i - coin] + 1);
				}
			}
		}
		return f[m] == m ? - 1 : f[m];
	}

}
