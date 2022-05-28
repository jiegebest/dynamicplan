package 依赖前一个状态.矩阵.零维变量;

public class 面试题1617连续数列 {

	public int maxSubArray(int[] nums) {
		int curr = 0, max = nums[0];
		for (int num : nums) {
			curr = Math.max(curr + num, num);
			max = Math.max(max, curr);
		}
		return max;
	}

}
