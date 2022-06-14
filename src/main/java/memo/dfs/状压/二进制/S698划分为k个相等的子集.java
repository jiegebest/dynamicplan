package memo.dfs.状压.二进制;

import java.util.Arrays;

/**
 是否有可能 > 题目只问我们是不是可以划分，没有问我们应该怎样划分
 len(nums) <= 16 子集访问情况可以用状态压缩表示
 */
public class S698划分为k个相等的子集 {

	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (k == 1) {
			return true;
		}

		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % k != 0) {
			return false;
		}
		int d = sum / k;
		int n = nums.length;
		Arrays.sort(nums);
		if (nums[n - 1] > d) {
			return false;
		}

		int size = 1 << n;
		int[] g = new int[size];
		boolean[] f = new boolean[size];
		f[0] = true;
		for (int i = 0; i < size; ++i) {
			if (!f[i]) {
				continue;
			}
			for (int j = 0; j < n; ++j) {
				if ((i & (1 << j)) != 0) {
					continue;
				}
				int next = i | (1 << j);
				if (f[next]) {
					continue;
				}
				if ((g[i] % d) + nums[j] <= d) {
					g[next] = g[i] + nums[j];
					f[next] = true;
				} else {
					break;
				}
			}
		}
		return f[size - 1];
	}

}
