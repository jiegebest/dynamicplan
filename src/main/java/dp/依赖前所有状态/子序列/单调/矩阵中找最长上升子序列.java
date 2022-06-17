package dp.依赖前所有状态.子序列.单调;

import util.PrintUtil;

import java.util.Arrays;

public class 矩阵中找最长上升子序列 {

	public int[][] findLongestIncreaseSequences(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] f = new int[m][n];
		for (int i = 0; i < m; ++i) {
			Arrays.fill(f[i], 1);
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				// i-1行及以前
				for (int x = 0; x < i; ++x) {
					for (int y = 0; y < n; ++y) {
						if (matrix[x][y] < matrix[i][j]) {
							f[i][j] = Math.max(f[x][y], f[x][y] + 1);
						}
					}
				}
				// 第 i 行
				for (int y = 0; y < j; ++y) {
					if (matrix[i][y] < matrix[i][j]) {
						f[i][j] = Math.max(f[i][y], f[i][y] + 1);
					}
				}
			}
		}
		return f;
	}

	/*
	public int[][] findLongestIncreaseSequences(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int k = m * n;
		int[] arr = new int[k];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				arr[i * n + j] = matrix[i][j];
			}
		}

		int[] f = new int[k];
		Arrays.fill(f, 1);
		for (int i = 0; i < k; ++i) {
			for (int j = 0; j < i; ++j) {
				if (arr[j] < arr[i]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				matrix[i][j] = f[i * n + j];
			}
		}
		return matrix;
	}
	*/

	/*
		1 4 7       1 2 3
		2 5 8 ->  2 3 4
		3 6 9       3 4 5
	 */
	public static void main(String[] args) {
		int[][] arr = new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
		int[][] mat = new 矩阵中找最长上升子序列().findLongestIncreaseSequences(arr);
		PrintUtil.printMatrix(mat);
	}

}
