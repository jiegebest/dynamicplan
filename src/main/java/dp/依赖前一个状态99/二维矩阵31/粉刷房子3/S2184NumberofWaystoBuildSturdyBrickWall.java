package dp.依赖前一个状态99.二维矩阵31.粉刷房子3;

import java.util.*;

/**
 * 非常经典!
 * 先来个状压dp，求出所有填满width的可能状态，
 * 再用邻接表记录状态 i 能转移到哪些状态 j，最后就dp推出最后一层的所有状态数量。
 *
 * 9个缝隙 状态压缩
 * 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10
 * 1 << (n - 1 - i)
 *
 * 76
 * 9
 * [6,3,5,1,9]
 * out 313242795
 * exp 201495766
 *
 * todo 有空再看
 */
public class S2184NumberofWaystoBuildSturdyBrickWall {

	static final int MOD = 1000000007;
	List<Integer> bitmask = new ArrayList<>();

	public int buildWall(int height, int width, int[] bricks) {
		dfs(width, bricks, 0, 0);

		int n = bitmask.size();
		int[][] related = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i != j && (bitmask.get(i) & bitmask.get(j)) == 0) {
					related[i][j] = 1;
				}
			}
		}

		int[][] f = new int[height][n];
		Arrays.fill(f[0], 1);
		for (int i = 1; i < height; ++i) {
			for (int j = 0; j < n; ++j) {
				for (int k = 0; k < n; ++k) {
					if (related[j][k] != 0) {
						f[i][j] = (f[i][j] + f[i - 1][k]) % MOD;
					}
				}
			}
		}

		int ans = 0;
		for (int j = 0; j < n; ++j) {
			ans = (ans + f[height - 1][j]) % MOD;
		}
		return ans;
	}

	public void dfs (int width, int[] bricks, int bits, int curr) {
		if (curr == width) {
			bitmask.add(bits - (1 << (width - 1)));
			return;
		}

		for (int brick : bricks) {
			if (curr + brick <= width) {
				curr += brick;
				// 砖头从右往左累加
				dfs(width, bricks, bits | (1 << (curr - 1)), curr);
				curr -= brick;
			}
		}
	}

	public static void main(String[] args) {
		int[] bricks = {6,3,5,1,9};
		System.out.println(new S2184NumberofWaystoBuildSturdyBrickWall().buildWall(76, 9, bricks));
	}

}
