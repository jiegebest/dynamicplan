package dp.依赖前一个状态.坐标.二维矩阵.模拟;

public class S1641统计字典序元音字符串的数目 {

	public int countVowelStrings(int n) {
		int m = 5;
		int[][] f = new int[n][m];
		for (int i = 0; i < n; ++i) {
			f[i][0] = 1;
		}
		for (int j = 1; j < m; ++j) {
			f[0][j] = 1;
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < m; ++j) {
				f[i][j] = f[i][j - 1] + f[i - 1][j];
			}
		}

		int cnt = 0;
		for (int curt : f[n - 1]) {
			cnt += curt;
		}
		return cnt;
	}

}
