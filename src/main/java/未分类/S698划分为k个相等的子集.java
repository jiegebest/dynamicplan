package 未分类;

import java.util.Arrays;

public class S698划分为k个相等的子集 {

	/**
	 有可能不代表一定
	 1 <= k <= len(nums) <= 16
	 数组子集个数为2^n，当len有长度限制时，且长度在32以内，子集个数就有上限，子集的各种组合就可以用状态压缩 1<<len 来表示，最多左移32位
	 比如 6 5 5 4 可以用 3=11 代表 6和5组成的集合
	 子集，可以用二进制bits表示，所有的集合组合就可以用 1~2^n-1来表示了
	 */
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

		Arrays.sort(nums);
		int avg = sum / k, n = nums.length;
		if (nums[n - 1] > avg) {
			return false;
		}

		int size = 1 << n;
		boolean[] f = new boolean[size];
		f[0] = true;
		int[] currSum = new int[size];

		// 遍历所有的子集组合,不符合的跳过，已处理的也跳过
		for (int i = 0; i < size; ++i) {
			if (!f[i]) {
				continue;
			}
			for (int j = 0; j < n; ++j) {
				if ((i & (1 << j)) == 1) {
					continue;
				}
				int next = i | (1 << j);
				if (f[next]) {
					continue;
				}
				// 始终保持f[i]是一个能够整除k的集合(取模后的余数=avg)，或者取模后的余数 < avg
				if ((currSum[i] % avg) + nums[j] > avg) {
					break;
				}
				f[next] = true;
				currSum[next] = currSum[i] + nums[j];
			}
		}

		return f[size - 1];
	}

}
