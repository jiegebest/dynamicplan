package 依赖前几个状态.解码方法;

public class 剑指Offer46把数字翻译成字符串 {

	public int translateNum(int num) {
		String str = String.valueOf(num);
		int a = 0, b = 1, c = 1;
		for (int i = 1; i < str.length(); ++i) {
			a = b;
			b = c;
			if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2' && str.charAt(i) < '6') {
				c += a;
			}
		}
		return c;
	}

}
