package 依赖前一个状态.背包._01背包;

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

		int n = nums.length, m = diff / 2;
		int[][] f = new int[n + 1][m + 1];
		f[0][0] = 1;
		for (int i = 1; i <= n; ++i) {
			for (int j = 0; j <= m; ++j) {
				int num = nums[i - 1];
				f[i][j] = f[i - 1][j];
				if (num <= j) {
					f[i][j] += f[i - 1][j - num];
				}
			}
		}
		return f[n][m];
	}

}
