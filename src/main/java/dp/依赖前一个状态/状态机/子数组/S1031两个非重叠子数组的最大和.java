package dp.依赖前一个状态.状态机.子数组;

/**
 * 拆
 * 单个长度子数组最大值能求出来，两个长度，就开俩状态。
 *
 *
 长度为 n，就以 i 位置来定义状态。即两个 len 各自用到结尾的情况
 两个 len，可以用状态机分别表示，即 f[i] g[i]
 而一定区间的和可以用前缀和预处理，在常数时间得到任意子数组和

  f[i]表示, 前i个元素, 子数组长度为f的最大和。
 g[i]表示, 前i个元素, 子数组长度为s的最大和。

 遍历一遍数组，要求最大值有两种情况
 1.以当前元素结尾的长度为f的子数组和 s1 + 前面长度为s的最大子数组和
 即 s1 + dp[i-f][1]
 2.以当前元素结尾的长度为s的子数组和 s2 + 前面长度为f的最大子数组和
 即 s2 + dp[i-s][0]
 两者取较大值即可
 */
public class S1031两个非重叠子数组的最大和 {

	public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
		int n = nums.length, len1 = firstLen, len2 = secondLen;
		int[] sum = new int[n + 1];
		for (int i = 0; i < n; ++i) {
			sum[i + 1] = sum[i] + nums[i];
		}

		if (len1 > len2) {
			int temp = len1;
			len1 = len2;
			len2 = temp;
		}

		int[] f = new int[n + 1];
		int[] g = new int[n + 1];
		int max = 0;
		for (int i = len1; i <= n; ++i) {
			int fLen = sum[i] - sum[i - len1];
			f[i] = Math.max(f[i - 1], fLen);
			max = Math.max(max, fLen + g[i - len1]);
			if (len2 <= i) {
				int gLen = sum[i] - sum[i - len2];
				g[i] = Math.max(g[i - 1], gLen);
				max = Math.max(max, gLen + f[i - len2]);
			}
		}
		return max;
	}

}
