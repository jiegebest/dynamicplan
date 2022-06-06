package dp.依赖前一个状态99.一维数组6.子数组;

/**
 * 不能把数组真的去放大
 * 叫什么算法，不用去看
 * 能过 37/42 用例
 */
public class S1191K次串联后最大子数组之和 {

	static final int MOD = 1000000007;

	public int kConcatenationMaxSum(int[] arr, int k) {
		int m = arr.length, n = m * k;
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i) {
			nums[i] = arr[i % m];
		}

		int[] f = new int[n + 1];
		int max = 0;
		for (int i = 1; i <= n; ++i) {
			f[i] = Math.max((f[i - 1] + nums[i - 1]) % MOD, 0);
			max = Math.max(max, f[i]);
		}
		return max;
	}

}
