package 依赖前一个状态.矩阵.应用题;

public class S1641统计字典序元音字符串的数目 {

	// 跟前一个状态有关 将aeiou抽象成数字01234 f[i][j] 代表第i轮以j结尾的数目
	public int countVowelStrings(int n) {
		int[][] f = new int[2][5];
		// 以 a 结尾的串只能有一种 a aa aaa
		f[0][0] = 1;
		f[1][0] = 1;
		for (int j = 1; j <= 4; ++j) {
			f[0][j] = 1;
		}

		for (int i = 1; i < n; ++i) {
			for (int j = 1; j <= 4; ++j) {
				f[i % 2][j] = f[i % 2][j - 1] + f[(i - 1) % 2][j];
			}
		}

		int total = 0;
		for (int count : f[(n - 1) % 2]) {
			total += count;
		}
		return total;
	}

}
