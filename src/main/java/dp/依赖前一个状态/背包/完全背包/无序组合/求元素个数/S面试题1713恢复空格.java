package dp.依赖前一个状态.背包.完全背包.无序组合.求元素个数;

/**
 * 可允许未识别 f[i] = f[i - 1]
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
