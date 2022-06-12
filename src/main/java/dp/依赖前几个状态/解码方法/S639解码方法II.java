package dp.依赖前几个状态.解码方法;

public class S639解码方法II {

	static final int MOD = 1000000007;

	public int numDecodings(String s) {
		int n = s.length();
		long[] f = new long[n + 1];
		f[0] = f[1] = 1;
		for (int i = 1; i <= n; ++i) {
			char curr = s.charAt(i - 1);
			f[i] = (f[i - 1] * oneDigitCount(curr)) % MOD;
			if (i > 1) {
				char prev = s.charAt(i - 2);
				f[i] = (f[i] + f[i - 2] * twoDigitCount(prev, curr)) % MOD;
			}
		}
		return (int) f[n];
	}

	public int oneDigitCount(char c) {
		if (c == '0') {
			return 0;
		}
		return c == '*' ? 9 : 1;
	}

	public int twoDigitCount(char c1, char c2) {
		if (c1 == '*' && c2 == '*') {
			return 9 + 6;
		}
		if (c1 == '*') {
			return c2 > '6' ? 1 : 2;
		}
		if (c2 == '*') {
			if (c1 == '1') {
				return 9;
			}
			if (c1 == '2') {
				return 6;
			}
			return 0;
		}
		return c1 == '1' || c1 == '2' && c2 <= '6' ? 1 : 0;
	}

}
