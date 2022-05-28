package 依赖前所有状态.升序接龙;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S368最大整除子集 {

	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		int[] f = new int[n];

		Arrays.sort(nums);
		Arrays.fill(f, 1);

		int best = 1, index = 0;
		for (int i = 1; i < n; ++i) {
			int curr = 1;
			for (int j = 0; j < i; ++j) {
				if (nums[i] % nums[j] == 0) {
					curr = Math.max(curr, f[j] + 1);
				}
			}
			f[i] = curr;
			if (curr > best) {
				best = curr;
				index = i;
			}
		}

		// 倒推获得最大子集
		List<Integer> list = new ArrayList<>(best);
		int num = nums[index];
		list.add(num);
		for (int i = index - 1; i >= 0; i--) {
			if (f[i] + 1 == best && num % nums[i] == 0) {
				list.add(nums[i]);
				num = nums[i];
				best--;
			}
		}
		return list;
	}

}
