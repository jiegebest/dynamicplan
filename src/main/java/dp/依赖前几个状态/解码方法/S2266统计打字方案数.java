package dp.依赖前几个状态.解码方法;

public class S2266统计打字方案数 {

	public int countTexts(String pressedKeys) {
		int MOD = 1_000_000_007;
		int n = pressedKeys.length();
		pressedKeys = " " + pressedKeys;
		int[] f = new int[n + 1];
		f[0] = 1;

		for (int i = 1; i <= n; ++i) {
			if (pressedKeys.charAt(i) <= '6' || pressedKeys.charAt(i) == '8') {
				for (int j = 1; j <= 3; ++j) {
					if (i - j >= 0 && pressedKeys.charAt(i) == pressedKeys.charAt(i - j + 1)) {
						f[i] = (f[i] + f[i - j]) % MOD;
					} else {
						break;
					}
				}
			} else {
				for (int j = 1; j <= 4; ++j) {
					if (i - j >= 0 && pressedKeys.charAt(i) == pressedKeys.charAt(i - j + 1)) {
						f[i] = (f[i] + f[i - j]) % MOD;
					} else {
						break;
					}
				}
			}
		}

		return f[n];
	}

}
