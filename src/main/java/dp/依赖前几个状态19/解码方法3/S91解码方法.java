package dp.依赖前几个状态19.解码方法3;

/**
 * 12 > 1 exp 2
 */
public class S91解码方法 {

	public int numDecodings(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}
		int n = s.length();
		int[] f = new int[n + 1];
		// 希望从空串或者单字符开始向后继承, 所以开局都是1
		f[0] = f[1] = 1;
		for (int i = 2; i <= n; ++i) {
			if (s.charAt(i - 1) != '0') {
				f[i] = f[i - 1];
			}
			if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
				f[i] += f[i - 2];
			}
		}
		return f[n];
	}

}
