package dp.依赖前一个状态.状态机.取模1;

/**
 * 0-除3余0
 * 1-除3余1
 * 2-除3余2
 */
public class S1262可被三整除的最大和 {

	public int maxSumDivThree(int[] nums) {
		int len = nums.length;
		int[][] f = new int[len + 1][3];
		f[0][1] = f[0][2] = Integer.MIN_VALUE;

		for (int i = 1; i <= len; ++i) {
			int n = nums[i - 1];
			if (n % 3 == 0) {
				f[i][0] = f[i - 1][0] + n;
				f[i][1] = f[i - 1][1] + n;
				f[i][2] = f[i - 1][2] + n;
			} else if (n % 3 == 1) {
				f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] + n);
				f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] + n);
				f[i][2] = Math.max(f[i - 1][2], f[i - 1][1] + n);
			} else {
				f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + n);
				f[i][1] = Math.max(f[i - 1][1], f[i - 1][2] + n);
				f[i][2] = Math.max(f[i - 1][2], f[i - 1][0] + n);
			}
		}

		return f[len][0];
	}

}
