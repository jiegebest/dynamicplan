package 依赖后一个状态;

import java.util.Arrays;

/**
 * 返回 源字符串 source 中能通过串联形成目标字符串 target 的 子序列 的最小数量
 * 思路：遍历的过程中，每次向下匹配，就可能能匹配较多的字母。
 * 需要找到 target 在 i 位置的一个字母，在 src对应下一个位置在哪里。（因为连接用的是子序列，不是子串）
 * 因此 src 中每个下标起点开始，某个字母下一个匹配的位置在哪里，这个要进行预处理。
 * 如果没有，就设置 src 的长度 s。
 */
public class S1055形成字符串的最短路径 {

	public int shortestWay(String source, String target) {
		int sn = source.length();
		int tn = target.length();
		int[][] f = new int[sn][26];
		Arrays.fill(f[sn - 1], sn);
		f[sn - 1][source.charAt(sn - 1) - 'a'] = sn - 1;
		for (int i = sn - 2; i >= 0; --i) {
			for (int j = 0; j < 26; ++j) {
				f[i][j] = source.charAt(i) == j + 'a' ? i : f[i + 1][j];
			}
		}

		int cnt = 0, ti = 0;
		while (ti < tn) {
			cnt++;
			int si = 0;
			if (f[si][target.charAt(ti) - 'a'] == sn) {
				return -1;
			}
			while (si < sn && ti < tn && f[si][target.charAt(ti) - 'a'] != sn) {
				si = f[si][target.charAt(ti) - 'a'] + 1;
				++ti;
			}
		}
		return cnt;
	}

}
