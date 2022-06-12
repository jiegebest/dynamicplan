package dp.依赖前一个状态.一维数组.子数组;


/**
 * 1. 单数组最大和
 * 2. 最大后缀和+最大前缀和
 * 3. k > 2 & sum > 0 最大后缀和 + 最大前缀和 + (k-2) * sum
 * 取三者较大值
 */
public class S1191K次串联后最大子数组之和 {

	public int kConcatenationMaxSum(int[] arr, int k) {
		int n = arr.length;
		int MOD = 1_000_000_007;
		long max = Integer.MIN_VALUE, pre = 0, preSum = 0, maxPreSum = 0;
		for (int i = 0; i < n; ++i) {
			pre = Math.max(pre + arr[i], 0);
			max = Math.max(max, pre);
			preSum += arr[i];
			maxPreSum = Math.max(maxPreSum, preSum);
		}

		long sufSum = 0, maxSufSum = 0;
		if (k > 1) {
			for (int i = n - 1; i >= 0; --i) {
				sufSum += arr[i];
				maxSufSum = Math.max(maxSufSum, sufSum);
			}
			max = Math.max(max, maxSufSum + maxPreSum);
		}

		if (k > 2 && preSum > 0) {
			max = Math.max(max, maxSufSum + (k - 2) * preSum + maxPreSum);
		}

		max %= MOD;
		return (int) max;
	}

}
