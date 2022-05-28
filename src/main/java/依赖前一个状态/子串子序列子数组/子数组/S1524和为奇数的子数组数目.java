package 依赖前一个状态.子串子序列子数组.子数组;

public class S1524和为奇数的子数组数目 {

	/**
	 前缀和之差，超时
	 不需要记录各个区间的和，而是记录前面出现子数组的奇偶性计数，方便后面直接进行累加
	 前缀和为奇数 += 前面前缀和为偶数的个数 = 两个前缀和之间的和是偶数
	 前缀和为偶数 += 前面前缀和为奇数的个数 = 两个前缀和之间的和是奇数
	 */
	public int numOfSubarrays(int[] arr) {
		int n = arr.length;
		int[] prefixSum = new int[n + 1];

		int count = 0, even = 1, odd = 0;
		for (int i = 1; i <= n; ++i) {
			prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
			if ((prefixSum[i] & 1) == 0) {
				count = (count + odd) % 1000000007;
				even++;
			} else {
				count = (count + even) % 1000000007;
				odd++;
			}
		}
		return count;
	}

}
