package dp.依赖前一个状态.背包.完全背包.无序组合.求组合个数;

public class S377组合总和Ⅳ {

	public int combinationSum4(int[] nums, int target) {
		int m = target;
		int[] f = new int[m + 1];
		f[0] = 1;
		for (int i = 1; i <= m; ++i) {
			for (int num : nums) {
				if (i >= num) {
					f[i] += f[i - num];
				}
			}
		}
		return f[m];
	}

}
