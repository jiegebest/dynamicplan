package 未分类;

public class S面试题0814布尔运算 {

	public int countEval(String s, int result) {
		int n = s.length();
		int[][][] f = new int[n][n][2];
		for (int i = 0; i < n; i += 2) {
			f[i][i][0] = s.charAt(i) == '0' ? 1 : 0;
			f[i][i][1] = s.charAt(i) == '1' ? 1 : 0;
		}

		for (int len = 3; len <= n; len += 2) {
			for (int i = 0; i < n - len + 1; i += 2) {
				int j = i + len - 1;
				for (int k = i + 1; k < j; k += 2) {
					switch (s.charAt(k)) {
						case '&':
							f[i][j][0] += f[i][k - 1][0] * f[k + 1][j][0];
							f[i][j][0] += f[i][k - 1][1] * f[k + 1][j][0];
							f[i][j][0] += f[i][k - 1][0] * f[k + 1][j][1];
							f[i][j][1] += f[i][k - 1][1] * f[k + 1][j][1];
							break;
						case '|':
							f[i][j][0] += f[i][k - 1][0] * f[k + 1][j][0];
							f[i][j][1] += f[i][k - 1][0] * f[k + 1][j][1];
							f[i][j][1] += f[i][k - 1][1] * f[k + 1][j][0];
							f[i][j][1] += f[i][k - 1][1] * f[k + 1][j][1];
							break;
						case '^':
							f[i][j][0] += f[i][k - 1][0] * f[k + 1][j][0];
							f[i][j][1] += f[i][k - 1][0] * f[k + 1][j][1];
							f[i][j][1] += f[i][k - 1][1] * f[k + 1][j][0];
							f[i][j][0] += f[i][k - 1][1] * f[k + 1][j][1];
							break;
					}
				}
			}
		}

		return f[0][n - 1][result];
	}

}
