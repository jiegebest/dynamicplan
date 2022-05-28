package 依赖前一个状态.背包.完全背包;

public class S剑指OfferII104排列的数目 {

	// 完全背包不需要建立二维数组 需要搞定顺序问题只需要每个f[i]可以由所有元数据构建而来即可
	public int combinationSum4(int[] nums, int target) {
		int[] f = new int[target + 1];
		f[0] = 1;

		for (int i = 1; i <= target; ++i) {
			for (int num : nums) {
				if (num <= i) {
					f[i] += f[i - num];
				}
			}
		}

		return f[target];
	}

}
