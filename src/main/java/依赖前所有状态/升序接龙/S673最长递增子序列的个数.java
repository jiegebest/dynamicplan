package 依赖前所有状态.升序接龙;

import java.util.Arrays;

public class S673最长递增子序列的个数 {

	// 子序列可重复
	// 增加cnt数组记录有多少最近前置状态到达
	// 相等增加cnt计数，超过重置cnt计数 收集最大值和计数也是
	// 返回个数，就不能只有长度f，还得有个数f
	public int findNumberOfLIS(int[] nums) {
		int n = nums.length, max = 0, count = 0;
		int[] f = new int[n];
		int[] cnt = new int[n];
		Arrays.fill(f, 1);
		Arrays.fill(cnt, 1);

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (nums[j] >= nums[i]) {
					continue;
				}
				if (f[j] + 1 > f[i]) {
					f[i] = f[j] + 1;
					cnt[i] = cnt[j];
				} else if (f[j] + 1 == f[i]) {
					cnt[i] += cnt[j];
				}
			}
			if (f[i] > max) {
				max = f[i];
				count = cnt[i];
			} else if (f[i] == max) {
				count += cnt[i];
			}
		}

		return count;
	}

}
