package 依赖前一个状态.背包._01背包;

/**
 * fi,j,k 前i个字符串组成的最长子集，j为0的个数，k为1的个数
 */
public class S474一和零 {

	public int findMaxForm(String[] strs, int m, int n) {
		int len = strs.length;
		int[][] f = new int[m + 1][n + 1];

		for (int i = 1; i <= len; ++i) {
			int[] arr = getZeroOne(strs[i - 1]);
			int zeros = arr[0];
			int ones = arr[1];
			for (int j = m; j >= zeros; j--) {
				for (int k = n; k >= ones; k--) {
					f[j][k] = Math.max(f[j][k], f[j - zeros][k - ones] + 1);
				}
			}
		}
		return f[m][n];
	}

	public int[] getZeroOne(String str) {
		int[] arr = new int[2];
		for (char ch : str.toCharArray()) {
			if (ch == '0') {
				arr[0]++;
			} else {
				arr[1]++;
			}
		}
		return arr;
	}

}





