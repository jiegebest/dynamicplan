package dp.依赖前一个状态99.二维矩阵31.矩阵模拟移动3;

/**
 * 跟前一个状态有关 将aeiou抽象成数字01234 f[i][j] 代表第i轮以j结尾的数目
 * 以 a 结尾的串只能有一种 a aa aaa
 */
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

		int total = 0;
		for (int cnt : f[n - 1]) {
			total += cnt;
		}
		return total;
	}

}
