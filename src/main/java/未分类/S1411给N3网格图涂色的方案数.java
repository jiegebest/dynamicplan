package 未分类;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 n*3网格，颜色也是3种，那么颜色比如说0，1，2，有序的放置在3元网格中，那么可以看做是三进制数，依次消除掉网格的横向维度。
 f[i][j] 第i行，i种颜色组合
 */
public class S1411给N3网格图涂色的方案数 {

	static final int MOD = 1000000007;

	public int numOfWays(int n) {
		List<Integer> colors = new ArrayList<>();
		// 左右不同色
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				for (int k = 0; k < 3; ++k) {
					if (i != j && j != k) {
						colors.add(i * 9 + j * 3 + k);
					}
				}
			}
		}

		// 上下不同色
		int size = colors.size();
		int[][] matches = new int[size][size];
		for (int i = 0; i < size; ++i) {
			int x1 = colors.get(i) / 9;
			int x2 = (colors.get(i) % 9) / 3;
			int x3 = colors.get(i) % 3;
			for (int j = 0; j < size; ++j) {
				int y1 = colors.get(j) / 9;
				int y2 = (colors.get(j) % 9) / 3;
				int y3 = colors.get(j) % 3;
				if (x1 != y1 && x2 != y2 && x3 != y3) {
					matches[i][j] = 1;
				}
			}
		}

		// 递推填充
		int[][] f = new int[n + 1][size];
		Arrays.fill(f[1], 1);

		for (int i = 2; i <= n; ++i) {
			for (int j = 0; j < size; ++j) {
				for (int k = 0; k < size; ++k) {
					if (matches[j][k] == 1) {
						f[i][j] = (f[i][j] + f[i - 1][k]) % MOD;
					}
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < f[0].length; ++i) {
			ans = (ans + f[n][i]) % MOD;
		}
		return ans;
	}

}
