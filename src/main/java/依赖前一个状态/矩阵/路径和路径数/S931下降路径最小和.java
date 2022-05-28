package 依赖前一个状态.矩阵.路径和路径数;

/**
 * best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
 */
public class S931下降路径最小和 {

	public int minFallingPathSum(int[][] A) {
		int N = A.length;
		for (int r = N-2; r >= 0; --r) {
			for (int c = 0; c < N; ++c) {
				int min = A[r+1][c];
				if (c > 0)
					min = Math.min(min, A[r+1][c-1]);
				if (c+1 < N)
					min = Math.min(min, A[r+1][c+1]);
				A[r][c] += min;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int x: A[0])
			min = Math.min(min, x);
		return min;
	}

}
