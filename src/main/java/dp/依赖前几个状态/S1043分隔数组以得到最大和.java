package dp.依赖前几个状态;

/**
 * 长度最多为 k，并没有说多少组
 */
public class S1043分隔数组以得到最大和 {

	public int maxSumAfterPartitioning(int[] arr, int k) {
		int n = arr.length;
		int[] f = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			int max = arr[i - 1];
			for (int j = 1; j <= Math.min(i, k); ++j) {
				max = Math.max(max, arr[i - j]);
				f[i] = Math.max(f[i], f[i - j] + max * j);
			}
		}
		return f[n];
	}

}
