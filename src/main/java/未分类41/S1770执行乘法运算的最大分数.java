package 未分类41;

public class S1770执行乘法运算的最大分数 {

	public int maximumScore(int[] nums, int[] multipliers) {
		int n = nums.length,m = multipliers.length;
		int[][] f = new int[1000 + 5][1000 + 5];
		f[0][0] = 0;
		for (int i = 1;i <= m;++i) f[i][0] = f[i - 1][0] + nums[i - 1] * multipliers[i - 1];
		for (int j = 1;j <= m;++j) f[0][j] = f[0][j - 1] + nums[n - j] * multipliers[j - 1];
		for (int i = 1;i <= m;++i){
			for (int j = 1;i + j <= m;++j){
				f[i][j] = Math.max(f[i - 1][j] + nums[i - 1] * multipliers[i + j - 1],f[i][j - 1] + nums[n - j] * multipliers[i + j - 1]);
			}
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 0;i <= m;++i) ans = Math.max(ans,f[i][m - i]);
		return ans;
	}

}
