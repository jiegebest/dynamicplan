package math;

/**
 每位单乘
 然后做字符串加法
 最后要记得加 carry 位
 "9133" "0" > "0000"
 */
public class S43字符串相乘 {

	public String multiply(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2)) {
			return "0";
		}

		String str = "";
		StringBuilder sb = new StringBuilder();
		for (int i = num2.length() - 1; i >= 0; --i) {
			String temp = multiplySingle(num1, num2.charAt(i) - '0');
			str = addTwoString(str, temp + sb.toString());
			sb.append("0");
		}
		return str;
	}

	public String multiplySingle(String str, int n) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = str.length() - 1; i >= 0; --i) {
			int temp = (str.charAt(i) - '0') * n + carry;
			carry = temp / 10;
			sb.append(temp % 10);
		}
		if (carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}

	public String addTwoString(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int i = s1.length() - 1, j = s2.length() - 1;
		while (i >= 0 || j >= 0) {
			int a = i >= 0 ? s1.charAt(i--) - '0' : 0;
			int b = j >= 0 ? s2.charAt(j--) - '0' : 0;
			int temp = a + b + carry;
			carry = temp / 10;
			sb.append(temp % 10);
		}
		if (carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}

}