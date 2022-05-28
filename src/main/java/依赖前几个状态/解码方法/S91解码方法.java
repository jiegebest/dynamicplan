package 依赖前几个状态.解码方法;

public class S91解码方法 {

	public int numDecodings(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}

		int a = 0, b = 1;
		for (int i = 1; i <= s.length(); ++i) {
			int temp = 0;
			if (s.charAt(i - 1) != '0') {
				temp += b;
			}
			if (i > 1 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
				temp += a;
			}
			a = b;
			b = temp;
		}
		return b;
	}

}
