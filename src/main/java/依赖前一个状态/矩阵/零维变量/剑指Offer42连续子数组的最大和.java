package 依赖前一个状态.矩阵.零维变量;

public class 剑指Offer42连续子数组的最大和 {

	public int maxSubArray(int[] nums) {
		int curr = 0, best = nums[0];
		for (int num : nums) {
			curr = Math.max(curr + num, num);
			best = Math.max(best, curr);
		}
		return best;
	}

}
