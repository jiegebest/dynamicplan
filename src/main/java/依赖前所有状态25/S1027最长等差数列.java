package 依赖前所有状态25;

/**
 * f d等差值 第i个 值=长度 f[i][d] = Math.max(f[j][d]) j < i
 */
public class S1027最长等差数列 {

	public int longestArithSeqLength(int[] nums) {
		int n = nums.length;
		int[][] f = new int[n][1010];
		int max = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				int d = nums[i] - nums[j] + 500;
				f[i][d] = Math.max(f[i][d], f[j][d] + 1);
				max = Math.max(max, f[i][d]);
			}
		}
		return max + 1;
	}

}
