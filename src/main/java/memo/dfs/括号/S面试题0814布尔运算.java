package memo.dfs.括号;

import java.util.Arrays;

/**
 * 括号问题 左右匹配
 * 计算所有结果 DFS
 * 状态机 左右
 左子规模
 右子规模

 dfs 要知道所有可能

 结果搞来搞去就两种，要么是 1，要么是 0
 */
public class S面试题0814布尔运算 {

	public int countEval(String s, int result) {
		int n = s.length();
		int[][][] f = new int[n][n][2];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				Arrays.fill(f[i][j], -1);
			}
		}
		return dfs(s.toCharArray(), f, 0, n - 1, result);
	}

	public int dfs(char[] arr, int[][][] f, int start, int end, int res) {
		if (f[start][end][res] != -1) {
			return f[start][end][res];
		}
		if (start == end) {
			return arr[start] - '0' == res ? 1 : 0;
		}

		int cnt = 0;
		for (int k = start + 1; k <= end - 1; k += 2) {
			for (int i = 0; i <= 1; ++i) {
				for (int j = 0; j <= 1; ++j) {
					if (getBoolAns(i, j, arr[k]) == res) {
						cnt += dfs(arr, f, start, k - 1, i) * dfs(arr, f, k + 1, end, j);
					}
				}
			}
		}
		f[start][end][res] = cnt;
		return cnt;
	}

	public int getBoolAns(int a, int b, int opt) {
		switch(opt) {
			case '^':
				return a ^ b;
			case '|':
				return a | b;
			case '&':
				return a & b;
			default:
				return 0;
		}
	}

}
