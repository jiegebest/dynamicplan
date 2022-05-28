package 依赖前一个状态.背包.完全背包;

/**
 * 好题
 */
public class 面试题0811硬币 {

	// 1. 从一个金额凑到另一个金额，只能用一种没使用的硬币，而且之后不能再使用已用过的硬币。
	// 2. 在使用硬币的时候，可以用一次，也可以用多次，凑到不同的金额去。
	// 3. 通过有序使用硬币，保证不存在相同组合能够达到同一金额。也就是保证了结果组合无重复
	// 简单说就是不存在先用 10后用1，以及先用1后用10的情况。 两个10和一个1，只有一种组合会出现，就是 10+10+1
	static final int MOD = 1000000007;

	public int waysToChange(int n) {
		int[] f = new int[n + 1];
		int[] coins = new int[]{25, 10, 5, 1};
		f[0] = 1;

		for (int coin : coins) {
			for (int i = coin; i <= n; ++i) {
				f[i] = (f[i] + f[i - coin]) % MOD;
			}
		}

		return f[n];
	}

}
