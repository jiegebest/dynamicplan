package 依赖前一个状态.矩阵.零维变量;

public class S53最大子数组和 {

	public int maxSubArray(int[] nums) {
		int curr = 0, max= Integer.MIN_VALUE;
		for (int num : nums) {
			curr = Math.max(curr + num, num);
			max = Math.max(max, curr);
		}
		return max;
	}

}
