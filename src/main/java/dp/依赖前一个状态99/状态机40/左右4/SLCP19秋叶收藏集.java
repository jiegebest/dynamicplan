package dp.依赖前一个状态99.状态机40.左右4;

import java.util.Arrays;

/**
 * 状态 0 和状态 2 分别表示前面和后面的红色部分，状态 1 表示黄色部分
 * 第 i 片叶子处于状态 j 时的最小操作次数
 * 状态机
 * 0-左 r
 * 1-中 y
 * 2-右 r
 * 代价 = 左边 + 中间 + 右边
 */
public class SLCP19秋叶收藏集 {

	public int minimumOperations(String leaves) {
		int n = leaves.length();
		int[][] f = new int[n][3];
		int INF = Integer.MAX_VALUE / 2;
		for (int i = 0; i < n; ++i) {
			Arrays.fill(f[i], INF);
		}
		char[] chas = leaves.toCharArray();
		f[0][0] = chas[0] == 'y' ? 1 : 0;

		for (int i = 1; i < n; ++i) {
			if (chas[i] == 'y') {
				f[i][0] = f[i - 1][0] + 1;
				f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]);
				f[i][2] = Math.min(f[i - 1][1] + 1, f[i - 1][2] + 1);
			} else {
				f[i][0] = f[i - 1][0];
				f[i][1] = Math.min(f[i - 1][0] + 1, f[i - 1][1] + 1);
				f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]);
			}
		}

		return f[n - 1][2];
	}

}
