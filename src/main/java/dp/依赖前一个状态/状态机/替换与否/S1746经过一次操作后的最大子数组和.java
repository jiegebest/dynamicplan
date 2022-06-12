package dp.依赖前一个状态.状态机.替换与否;

/**
 * 最大子数组和
 * 状态机 f替换 g不替换
 * 包含当前位置的子数组
 * 子数组最大和始终是 >=0的
 *
 *  f[i] 截止 i 位置有替换过
 * g[i] 截止 i 位置没有替换过
 *
 * 好题
 */
public class S1746经过一次操作后的最大子数组和 {

	public int maxSumAfterOperation(int[] nums) {
		int n = nums.length;
		int[] f = new int[n + 1];
		int[] g = new int[n + 1];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; ++i) {
			f[i] = Math.max(f[i - 1] + nums[i - 1], g[i - 1] + nums[i - 1] * nums[i - 1]);
			g[i] = Math.max(g[i - 1] + nums[i - 1], 0);
			max = Math.max(max, f[i]);
		}
		return max;
	}

}
