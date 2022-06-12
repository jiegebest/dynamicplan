package dp.依赖后面的状态;

import java.util.Arrays;

/**
 * src 中每个下标起点开始，某个字母下一个匹配的位置在哪里，这个要进行预处理。
 */
public class S1055形成字符串的最短路径 {

	public int shortestWay(String source, String target) {
		int INF = Integer.MAX_VALUE / 2;
		int s = source.length();
		int t = target.length();
		int[][] f = new int[s][26];
		Arrays.fill(f[s - 1], INF);
		f[s - 1][source.charAt(s - 1) - 'a'] = s - 1;

		for (int i = s - 2; i >= 0; --i) {
			for (int j = 0; j < 26; ++j) {
				f[i][j] = (j == source.charAt(i) - 'a') ? i : f[i + 1][j];
			}
		}

		int cnt = 0, ti = 0;
		while (ti < t) {
			cnt++;
			int si = 0;
			if (f[si][target.charAt(ti) - 'a'] == INF) {
				return -1;
			}
			while (si < s && ti < t && f[si][target.charAt(ti) - 'a'] != INF) {
				si = f[si][target.charAt(ti) - 'a'] + 1;
				++ti;
			}
		}
		return cnt;
	}

}
