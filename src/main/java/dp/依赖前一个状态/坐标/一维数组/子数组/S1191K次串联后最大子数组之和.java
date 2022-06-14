package dp.依赖前一个状态.坐标.一维数组.子数组;


/**
 * 1. 单数组最大和
 * 2. 最大后缀和+最大前缀和
 * 3. k > 2 & sum > 0 最大后缀和 + 最大前缀和 + (k-2) * sum
 * 取三者较大值
 */
public class S1191K次串联后最大子数组之和 {

	public int kConcatenationMaxSum(int[] arr, int k) {
		int n = arr.length;
		int[] f = new int[n];
		f[0] = arr[0];
		long ans = arr[0], sum = arr[0], maxPrefixSum = arr[0];
		for (int i = 1; i < n; ++i) {
			f[i] = Math.max(f[i - 1] + arr[i], 0);
			ans = Math.max(ans, f[i]);
			sum += arr[i];
			maxPrefixSum = Math.max(maxPrefixSum, sum);
		}

		long suffixSum = 0, maxSuffixSum = 0;
		if (k > 1) {
			for (int i = n - 1; i >= 0; --i) {
				suffixSum += arr[i];
				maxSuffixSum = Math.max(maxSuffixSum, suffixSum);
			}
			ans = Math.max(ans, maxSuffixSum + maxPrefixSum);
		}

		if (k > 2 && sum > 0) {
			ans = Math.max(ans, maxSuffixSum + (k - 2) * sum + maxPrefixSum);
		}

		ans %= 1_000_000_007;
		return (int) ans;
	}

}
