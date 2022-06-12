package dp.依赖前一个状态.前缀.划分;

/**
 * 长度最多为 k（我看成分组个数最多为 k 了）
 * 最后一组的长度
 */
public class S1043分隔数组以得到最大和 {

	public int maxSumAfterPartitioning(int[] arr, int k) {
		int n = arr.length;
		int[] f = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			int max = arr[i - 1];
			for (int j = 1; j <= Math.min(k, i); ++j) {
				max = Math.max(max, arr[i - j]);
				f[i] = Math.max(f[i], f[i - j] + max * j);
			}
		}
		return f[n];
	}

}
