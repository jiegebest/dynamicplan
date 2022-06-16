package 字符串;

/**
 * 1234+1934=2468
 */
public class 字符串合并 {

	public String merge(String str1, String str2) {
		int p1 = str1.length() - 1, p2 = str2.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0, num = 0;
		while (p1 >= 0 || p2 >= 0) {
			int num1 = p1 >= 0 ? str1.charAt(p1--) - '0' : 0;
			int num2 = p2 >= 0 ? str2.charAt(p2--) - '0' : 0;
			num = num1 + num2 + carry;
			carry = num / 10;
			sb.append(num % 10);
		}
		if (carry == 1) {
			sb.append(1);
		}
		return sb.reverse().toString();
	}

}
