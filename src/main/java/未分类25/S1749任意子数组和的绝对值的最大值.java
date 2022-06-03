package 未分类25;

public class S1749任意子数组和的绝对值的最大值 {

	public int maxAbsoluteSum(int[] nums) {
		int len = nums.length;
		int[][] f = new int[len][2];

		f[0] = new int[]{nums[0], nums[0]}; // min, max
		int maxAns = Math.abs(nums[0]);
		for(int i=1;i<len;++i){
			// f[i][0] 表示以 nums[i] 结尾和最小的子数组
			f[i][0] = Math.min(nums[i], f[i-1][0] + nums[i]);
			// f[i][1] 表示以 nums[i] 结尾和最大的子数组
			f[i][1] = Math.max(nums[i], f[i-1][1] + nums[i]);

			maxAns = Math.max(maxAns, Math.abs(f[i][0]));
			maxAns = Math.max(maxAns, Math.abs(f[i][1]));
		}

		return maxAns;
	}

}
