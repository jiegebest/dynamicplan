package dp.依赖前所有状态25.升序接龙3;

import java.util.Arrays;

/**
 * 子序列可重复
 * 增加g数组记录有多少最近前置状态到达
 * 相等增加g计数，超过重置g计数 收集最大值和计数也是
 * 返回个数，就不能只有长度f，还得有个数f
 */
public class S673最长递增子序列的个数 {

	public int findNumberOfLIS(int[] nums) {
		int n = nums.length, max = 0, cnt = 0;
		int[] f = new int[n];
		int[] g = new int[n];
		Arrays.fill(f, 1);
		Arrays.fill(g, 1);

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (nums[j] >= nums[i]) {
					continue;
				}
				if (f[j] + 1 > f[i]) {
					f[i] = f[j] + 1;
					g[i] = g[j];
				} else if (f[j] + 1 == f[i]) {
					g[i] += g[j];
				}
			}
			if (f[i] > max) {
				max = f[i];
				cnt = g[i];
			} else if (f[i] == max) {
				cnt += g[i];
			}
		}
		return cnt;
	}

}
