package dp.依赖前一个状态.状态机.子数组;

/**
 * odd 奇数子数组数目
 * even 偶数子数组数目
 */
public class S1524和为奇数的子数组数目 {

	public int numOfSubarrays(int[] arr) {
		int n = arr.length, MOD = 1_000_000_007;
		int[] preSum = new int[n + 1];
		int[] odd = new int[n + 1];
		int[] even = new int[n + 1];
		odd[0] = 0;
		even[0] = 1;

		int cnt = 0;
		for (int i = 1; i <= n; ++i) {
			preSum[i] = preSum[i - 1] + arr[i - 1];
			odd[i] = odd[i - 1];
			even[i] = even[i - 1];
			if ((preSum[i] & 1) == 0) {
				// 总和为偶数，前面取奇数，剩下的子数组也是奇数
				cnt = (cnt + odd[i - 1]) % MOD;
				++even[i];
			} else {
				// 总和为奇数，前面取偶数，剩下的子数组也是奇数
				cnt = (cnt + even[i - 1]) % MOD;
				++odd[i];
			}
		}
		return cnt;
	}

}
