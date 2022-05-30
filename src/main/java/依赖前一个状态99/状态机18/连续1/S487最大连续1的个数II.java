package 依赖前一个状态99.状态机18.连续1;

/**
 * fi以i结尾
 * 未翻转
 * i=0 f[i][0] = 0
 * i=1 f[i][0] = f[i-1][0] + 1 当前翻
 * 翻转
 * i=0 f[i][1] = f[i-1][0] + 1
 * i=1 f[i][1] = f[i-1][1] + 1 之前翻
 */
public class S487最大连续1的个数II {

	public int findMaxConsecutiveOnes(int[] nums) {
		int n = nums.length;
		int[][] f = new int[n + 1][2];
		int max = 0;
		for (int i = 1; i <= n; ++i) {
			if (nums[i - 1] == 1) {
				f[i][0] = f[i - 1][0] + 1;
				f[i][1] = f[i - 1][1] + 1;
			} else {
				f[i][0] = 0;
				f[i][1] = f[i - 1][0] + 1;
			}
			max = Math.max(max, f[i][1]);
		}
		return max;
	}

}
