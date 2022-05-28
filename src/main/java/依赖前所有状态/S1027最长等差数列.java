package 依赖前所有状态;

public class S1027最长等差数列 {

	// f d等差值 第i个 值=长度 f[i][d] = Math.max(f[j][d]) j < i
	public int longestArithSeqLength(int[] nums) {
		int n = nums.length, ans = 0;
		int[][] f = new int[n][1010];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				int d = nums[i] - nums[j] + 500;
				f[i][d] = Math.max(f[i][d], f[j][d] + 1);
				ans = Math.max(ans, f[i][d]);
			}
		}

		return ans + 1;
	}

}
