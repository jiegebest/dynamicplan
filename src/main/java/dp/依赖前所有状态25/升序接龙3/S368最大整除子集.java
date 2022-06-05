package dp.依赖前所有状态25.升序接龙3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S368最大整除子集 {

	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		int[] f = new int[n];
		Arrays.sort(nums);
		Arrays.fill(f, 1);

		int max = 1, index = 0;
		for (int i = 1; i < n; ++i) {
			int curr = 1;
			for (int j = 0; j < i; ++j) {
				if (nums[i] % nums[j] == 0) {
					curr = Math.max(curr, f[j] + 1);
				}
			}
			f[i] = curr;
			if (curr > max) {
				max = curr;
				index = i;
			}
		}

		List<Integer> list = new ArrayList<>(max);
		int num = nums[index];
		list.add(num);
		for (int i = index - 1; i >= 0; --i) {
			if (f[i] + 1 == max && num % nums[i] == 0) {
				list.add(nums[i]);
				num = nums[i];
				max--;
			}
		}
		return list;
	}

}
