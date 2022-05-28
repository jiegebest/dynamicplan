package 依赖前所有状态.子序列;

import java.util.HashMap;
import java.util.Map;

public class S446等差数列划分II子序列 {

	/**
	 等差数列要跟踪尾数和等差值，以及个数
	 */
	public int numberOfArithmeticSlices(int[] nums) {
		int ans = 0, n = nums.length;
		Map<Long, Integer>[] cache = new HashMap[n];
		for (int i = 0; i < n; ++i) {
			cache[i] = new HashMap<>();
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				long d = (long) nums[i] - nums[j];
				int cnt = cache[j].getOrDefault(d, 0);
				ans += cnt;
				cache[i].put(d, cache[i].getOrDefault(d, 0) + cnt + 1);
			}
		}
		return ans;
	}

}
