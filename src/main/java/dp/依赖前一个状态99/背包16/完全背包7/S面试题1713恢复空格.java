package dp.依赖前一个状态99.背包16.完全背包7;

/**
 * 最少未识别字符 = n - 最大已识别字符
 */
public class S面试题1713恢复空格 {

	public int respace(String[] dictionary, String sentence) {
		int n = sentence.length();
		int[] f = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			f[i] = f[i - 1];
			for (String word : dictionary) {
				int w = word.length();
				if (i >= w && sentence.substring(i - w, i).equals(word)) {
					f[i] = Math.max(f[i], f[i - w] + w);
				}
			}
		}
		return n - f[n];
	}

}
