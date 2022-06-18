package sort;

import java.util.Arrays;

/**
 *  先排序，然后后面比前面大一即可
 */
public class S945使数组唯一的最小增量 {

	public int minIncrementForUnique(int[] nums) {
		Arrays.sort(nums);
		int cnt = 0;
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i - 1] >= nums[i]) {
				cnt += nums[i - 1] - nums[i] + 1;
				nums[i] = nums[i - 1] + 1;
			}
		}
		return cnt;
	}

}
