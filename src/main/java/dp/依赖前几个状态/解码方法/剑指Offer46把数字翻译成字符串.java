package dp.依赖前几个状态.解码方法;

public class 剑指Offer46把数字翻译成字符串 {

	public int translateNum(int num) {
		String str = String.valueOf(num);
		int n = str.length();
		int[] f = new int[n + 1];
		f[0] = f[1] = 1;
		for (int i = 2; i <= n; ++i) {
			f[i] = f[i - 1];
			if (i >= 2 && (str.charAt(i - 2) == '1' || str.charAt(i - 2) == '2' && str.charAt(i - 1) < '6')) {
				f[i] += f[i - 2];
			}
		}
		return f[n];
	}

}
