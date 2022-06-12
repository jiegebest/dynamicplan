package dp.依赖前特定状态._2的幂次;

public class S338比特位计数 {

	public int[] countBits(int n) {
		int[] f = new int[n + 1];
		int high = 0;
		for (int i = 1; i <= n; ++i) {
			if ((i & (i - 1)) == 0) {
				high = i;
			}
			f[i] = f[i - high] + 1;
		}
		return f;
	}
}
