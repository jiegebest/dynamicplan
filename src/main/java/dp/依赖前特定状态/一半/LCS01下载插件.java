package dp.依赖前特定状态.一半;

/**
 * 完成下载 n 个插件，并没有限制不能超
 */
public class LCS01下载插件 {

	public int leastMinutes(int n) {
		int[] f = new int[n + 1];
		f[1] = 1;
		for (int i = 2; i <= n; ++i) {
			// 只多不少，所以为避免除以 2 丢失余数，我们先把 i+1
			// 这样偶数还是原值，奇数也不会偏低，导致不够 i 个插件
			f[i] = 1 + f[(i + 1) / 2];
		}
		return f[n];
	}

}