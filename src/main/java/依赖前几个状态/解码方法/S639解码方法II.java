package 依赖前几个状态.解码方法;

public class S639解码方法II {

	static final int MOD = 1000000007;

	public int numDecodings(String s) {
		long a = 0, b = 1;
		for (int i = 1; i <= s.length(); ++i) {
			long temp = b * oneDigitCount(s.charAt(i - 1)) % MOD;
			if (i > 1) {
				temp = (temp + a * twoDigitCount(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
			}
			a = b;
			b = temp;
		}
		return (int) b;
	}

	public int oneDigitCount(Character ch) {
		if (ch == '0') {
			return 0;
		}
		return ch == '*' ? 9 : 1;
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
			return c1 == '2' ? 6 : 0;
		}
		return c1 == '1' || c1 == '2' && c2 <= '6' ? 1 : 0;
	}

}
