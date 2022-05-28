package 依赖前特定规则状态.完全平方数;

public class S338比特位计数 {

	// 如果一个数是2的幂次，那么 x & (x - 1) == 0
	public int[] countBits(int n) {
		int[] f = new int[n + 1];
		int high = 0;

		for (int i = 1; i <= n; ++i) {
			// & 的优先级要低一些
			if ((i & (i - 1)) == 0) {
				high = i;
			}
			f[i] = f[i - high] + 1;
		}

		return f;
	}
}
