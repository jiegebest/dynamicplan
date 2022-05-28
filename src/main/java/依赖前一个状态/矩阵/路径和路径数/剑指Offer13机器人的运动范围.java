package 依赖前一个状态.矩阵.路径和路径数;

public class 剑指Offer13机器人的运动范围 {

	public int movingcnt(int m, int n, int k) {
		boolean[][] f = new boolean[m][n];
		f[0][0] = true;

		int cnt = 1;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if ((i == 0 && j == 0) || getSum(i) + getSum(j) > k) {
					continue;
				}
				if (i > 0) {
					f[i][j] |= f[i - 1][j];
				}
				if (j > 0) {
					f[i][j] |= f[i][j - 1];
				}
				cnt += f[i][j] ? 1 : 0;
			}
		}
		return cnt;
	}

	public int getSum(int x) {
		int sum = 0;
		while (x != 0) {
			sum += x % 10;
			x /= 10;
		}
		return sum;
	}

}
