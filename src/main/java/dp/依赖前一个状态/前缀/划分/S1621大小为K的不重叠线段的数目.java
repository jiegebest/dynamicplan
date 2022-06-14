package dp.依赖前一个状态.前缀.划分;

/**
 * k 个线段不需要全部覆盖全部 n 个点，且它们的端点 可以 重合
 * 连续 or 不连续
 * 线段可以重合      f 右端点是 i 可延长
 * 要么增加线段长度为 1 的线段
 * 要么线段个数不变，只延长
 * 线段可以不重合  g 右端点不是 i, 第 i 个点没有用上，0~i-1 构成了 j 条线段
 */
public class S1621大小为K的不重叠线段的数目 {

	public int numberOfSets(int n, int k) {
		int[][] f = new int[n][k + 1];
		int[][] g = new int[n][k + 1];
		f[0][0] = 0;
		g[0][0] = 1;

		int MOD = 1_000_000_007;
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j <= k; ++j) {
				// 延长最后一个线段，长度 =1
				f[i][j] = f[i - 1][j];
				if (j > 0) {
					// 新增一个长度 =1 的线段
					f[i][j] = (f[i][j] + f[i - 1][j - 1]) % MOD;
					// 新增一个长度 >1 的线段
					f[i][j] = (f[i][j] + g[i - 1][j - 1]) % MOD;
				}
				// 到 i-1 就有 j  个线段了
				g[i][j] = (f[i - 1][j] + g[i - 1][j]) % MOD;
			}
		}

		return (f[n - 1][k] + g[n - 1][k]) % MOD;
	}

}
