package dp.依赖前一个状态.背包._01背包7.加减的目标值;

/**
 sum
 neg
 正数总和 sum - neg
 全正总和 = (sum - neg) - neg(负转正) = target
 sum - 2neg = target
 neg = (sum - target) / 2 需要添加为负数的数值
 sum - target >= 0 且是偶数

 f[i][j] = 前i当中选择,j为需要添加为负数的元素之和
 */
public class S494目标和 {

	public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		int diff = sum - target;
		if (diff < 0 || (diff & 1) == 1) {
			return 0;
		}

		int m = nums.length, n = diff / 2;
		int[][] f = new int[m + 1][n + 1];
		f[0][0] = 1;
		for (int i = 1; i <= m; ++i) {
			for (int j = 0; j <= n; ++j) {
				f[i][j] = f[i - 1][j];
				if (nums[i - 1] <= j) {
					f[i][j] += f[i - 1][j - nums[i - 1]];
				}
			}
		}
		return f[m][n];
	}

}
