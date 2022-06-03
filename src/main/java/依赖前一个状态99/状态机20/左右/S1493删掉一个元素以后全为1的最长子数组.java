package 依赖前一个状态99.状态机20.左右;

/**
 需要从中删掉一个元素，必删
 f 不删
 g 删
 */
public class S1493删掉一个元素以后全为1的最长子数组 {

	public int longestSubarray(int[] nums) {
		int n = nums.length;
		int[] f = new int[n];
		int[] g = new int[n];
		if (nums[0] == 1) {
			f[0] = 1;
		}

		int max = 0;
		for (int i = 1; i < n; ++i) {
			if (nums[i] == 1) {
				f[i] = f[i - 1] + 1;
				g[i] = Math.max(f[i - 1], g[i - 1] + 1);
			} else {
				f[i] = 0;
				g[i] = f[i - 1];
			}
			max = Math.max(max, Math.max(f[i] - 1, g[i]));
		}
		return max;
	}

}
