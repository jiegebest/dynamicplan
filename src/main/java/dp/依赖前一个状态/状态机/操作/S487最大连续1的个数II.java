package dp.依赖前一个状态.状态机.操作;

public class S487最大连续1的个数II {

	public int findMaxConsecutiveOnes(int[] nums) {
		int n = nums.length;
		// 0-未翻转 1-翻转
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
