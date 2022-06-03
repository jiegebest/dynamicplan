package 依赖前一个状态99.状态机20.子数组;

public class S1749任意子数组和的绝对值的最大值 {

	public int maxAbsoluteSum(int[] nums) {
		int pos = 0, neg = 0, max = 0;
		for (int num : nums) {
			pos = Math.max(0, Math.max(pos + num, num));
			neg = Math.min(0, Math.min(neg + num, num));
			max = Math.max(max, Math.max(pos, -neg));
		}
		return max;
	}

}
