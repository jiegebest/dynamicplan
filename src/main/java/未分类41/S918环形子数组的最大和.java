package 未分类41;

public class S918环形子数组的最大和 {

	/**
	 邻接数组：环形数组翻一倍展开，1<=len<=n
	 */
	public int maxSubarraySumCircular(int[] nums) {
		int total = 0;
		int currMax = 0, currMin = 0;
		int max = nums[0], min = nums[0];

		for (int num : nums) {
			total += num;
			currMax = Math.max(currMax + num, num);
			max = Math.max(max, currMax);
			currMin = Math.min(currMin + num, num);
			min = Math.min(min, currMin);
		}

		return max > 0 ? Math.max(max, total - min) : max;
	}

}
