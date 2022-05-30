package 未分类41;

public class S1043分隔数组以得到最大和 {

	// 前i个元素，最后一段区间长度为j 1<=j<=k
	public int maxSumAfterPartitioning(int[] arr, int k) {
		int n = arr.length;
		int[] f = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			int sum = 0, max = arr[i - 1];
			for (int j = 1; j <= Math.min(i, k); ++j) {
				max = Math.max(max, arr[i - j]);
				sum = Math.max(sum, f[i - j] + j * max);
			}
			f[i] = sum;
		}
		return f[n];
	}

}
