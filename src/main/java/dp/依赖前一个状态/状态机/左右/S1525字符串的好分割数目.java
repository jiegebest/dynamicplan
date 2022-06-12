package dp.依赖前一个状态.状态机.左右;

/**
 * 左右
 */
public class S1525字符串的好分割数目 {

	public int numSplits(String s) {
		// 预处理
		int n = s.length();
		int[] cnt = new int[26];
		for (int i = 0; i < n; ++i) {
			++cnt[s.charAt(i) - 'a'];
		}

		// 计算总类数
		int types = 0;
		for (int count : cnt) {
			if (count > 0) {
				++types;
			}
		}

		boolean[] f = new boolean[26];
		int left = 0, right = types, ans = 0;
		for (int i = 1; i <= n; ++i) {
			int index = s.charAt(i - 1) - 'a';
			if (!f[index]) {
				f[index] = true;
				++left;
			}
			if (--cnt[index] == 0) {
				--right;
			}
			if (left == right) {
				++ans;
			}
		}
		return ans;
	}

}
