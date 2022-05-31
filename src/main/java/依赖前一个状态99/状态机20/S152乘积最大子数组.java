package 依赖前一个状态99.状态机20;

/**
 * 0 最大数
 * 1 最小数
 */
public class S152乘积最大子数组 {

	public int maxProduct(int[] nums) {
		int n = nums.length;
		int[][] f = new int[n][2];
		f[0][0] = f[0][1] = nums[0];

		int max = nums[0];
		for (int i = 1; i < n; ++i) {
			f[i][0] = Math.max(n, Math.max(f[i - 1][0] * n, f[i - 1][1] * n));
			f[i][1] = Math.min(n, Math.min(f[i - 1][0] * n, f[i - 1][1] * n));
			max = Math.max(max, f[i][0]);
		}
		return max;
	}

}
