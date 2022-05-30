package 未分类41;

public class S2266统计打字方案数 {

	public int countTexts(String pressedKeys) {
		int mod = (int) 1e9 + 7;
		// 分两种情况，当前i与i-1的字符相同，不相同
		// 不相同：f[i] += f[i - 1]
		// 相同：与i-1相同 f[i] += f[i-1] + f[i-2]
		// 与i-2也相同：f[i] += f[i-3]
		int n = pressedKeys.length();
		char[] chs = pressedKeys.toCharArray();
		// f[i]表示以pressKey[i]结尾的方案个数
		long[] f = new long[n];
		f[0] = 1;
		for (int i = 1; i < n; ++i) {
			f[i] = f[i - 1];
			if (chs[i] == chs[i - 1]) {
				f[i] += i >= 2 ? f[i - 2] : 1;
				if (i >= 2 && chs[i] == chs[i - 2]) {
					f[i] += i >= 3 ? f[i - 3] : 1;
					if ((chs[i] == '7' || chs[i] == '9') && i >= 3 && chs[i] == chs[i - 3]) {
						f[i] += i >= 4 ? f[i - 4] : 1;
					}
				}
			}
			f[i] %= mod;
		}
		return (int) f[n - 1];
	}

}
