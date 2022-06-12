package dp.依赖前一个状态.二维矩阵.距离3;

import java.util.HashSet;
import java.util.Set;

/**
 上到下 0
 左到右 1
 下到上 2
 右到左 3
 */
public class S764最大加号标志 {

	public int orderOfLargestPlusSign(int n, int[][] mines) {
		Set<Integer> set = new HashSet<>();
		for (int[] arr : mines) {
			set.add(arr[0] * n + arr[1]);
		}

		int[][][] f = new int[n][n][4];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (set.contains(i * n + j)) {
					continue;
				}
				f[i][j][0] = f[i][j][1] = 1;
				if (i > 0) {
					f[i][j][0] += f[i - 1][j][0];
				}
				if (j > 0) {
					f[i][j][1] += f[i][j - 1][1];
				}
			}
		}
		for (int i = n - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; --j) {
				if (set.contains(i * n + j)) {
					continue;
				}
				f[i][j][2] = f[i][j][3] = 1;
				if (i < n - 1) {
					f[i][j][2] += f[i + 1][j][2];
				}
				if (j < n - 1) {
					f[i][j][3] += f[i][j + 1][3];
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				int currMin = Math.min(Math.min(f[i][j][0], f[i][j][2]), Math.min(f[i][j][1], f[i][j][3]));
				max = Math.max(max, currMin);
			}
		}
		return max;
	}

}
