package dp.不考;

import java.util.Arrays;

/**
 * 这道题位操作太狠了，面试绝无可能做出来
 *
 * 1 <= points.length <= 10
 * 状压 DFS
 * boolean[][] line 保存连线情况
 *
 * 1110011001
 *
 * 负数等于正数取反+1，拿到的是最高位1，其它 0
 *
 * i & (-i) 得到的是最后一个 1
 *
 * 位操作高效遍历所有子集 j 一开始=i
 * j = ((j - 1) & i)  <=>  执行一次少掉最右边的 1
 *
 * 如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。
 *
 * dp[i ^ j]  i 是访问过的，j 是 i 子集，i^j 是剩下的 1
 *
 *
 */
public class S2152穿过所有点的所需最少直线数量 {

	public int minimumLines(int[][] points) {
		int n = points.length;
		boolean[] sameLine = new boolean[1 << n];
		for (int i = 0; i < 1 << n; i++) {
			if (Integer.bitCount(i) <= 2) {
				sameLine[i] = true;
				continue;
			}

			if (!sameLine[i - (i & (-i))]) {
				sameLine[i] = false;
				continue;
			}

			int[] items = new int[3];
			int last = i;
			for (int j = 0; j < 3; j++) {
				int lastPos = Integer.bitCount((last & (-last)) - 1);
				last = last & (last - 1);
				items[j] = lastPos;
			}
			sameLine[i] = sameLine(points[items[0]], points[items[1]], points[items[2]]);
		}

		int[] dp = new int[1 << n];
		Arrays.fill(dp, n);
		dp[0] = 0;
		for (int i = 1; i < 1 << n; i++) {
			for (int j = i; j > 0; j = ((j - 1) & i)) {
				if (sameLine[j]) {
					dp[i] = Math.min(dp[i], dp[i ^ j] + 1);
				}
			}
		}
		return dp[(1 << n) - 1];
	}

	private boolean sameLine(int[] a, int[] b, int[] c) {
		return (a[1] - b[1]) * (a[0] - c[0]) == (a[0] - b[0]) * (a[1] - c[1]);
	}

	public static void main(String[] args) {
		// [[0,1],[2,3],[4,5],[4,3]]
		int[][] points = new int[][]{{0, 1}, {2, 3}, {4, 5}, {4, 3}};
		// System.out.println(new S2152穿过所有点的所需最少直线数量().minimumLines(points));
		// 11 11101
		System.out.println(Integer.bitCount(3 & (-3)));
	}

}
