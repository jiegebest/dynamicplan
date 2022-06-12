package dp.依赖前所有状态.子序列.单调;

import java.util.Arrays;

/**
 数组排序
 对于每一个字符串，看前面长度-1的字符串是否符合递进关系，符合的话 f[i] = Math.max(f[i], f[j] + 1)
 */
public class S1048最长字符串链 {

	public int longestStrChain(String[] words) {
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		int n = words.length;
		int[] f = new int[n];
		Arrays.fill(f, 1);

		int max = 1;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (matches(words[j], words[i])) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
			max = Math.max(max, f[i]);
		}
		return max;
	}

	public boolean matches(String word1, String word2) {
		int n = word1.length(), m = word2.length();
		if (n + 1 != m) {
			return false;
		}

		int diff = 0, i = 0, j = 0;
		while (i < n && j < m) {
			if (word1.charAt(i) == word2.charAt(j)) {
				++i;
			} else if (++diff == 2) {
				return false;
			}
			++j;
		}
		return i == n;
	}

}
