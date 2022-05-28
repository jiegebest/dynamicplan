package 依赖前一个状态.子串子序列子数组.子串;

public class S467环绕字符串中唯一的子字符串 {

	public int findSubstringInWraproundString(String p) {
		int n = p.length();
		int[] f = new int[26];

		int k = 0;
		for (int i = 0; i < n; ++i) {
			char ch = p.charAt(i);
			k = i > 0 && (ch - p.charAt(i - 1) + 26) % 26 == 1 ? k + 1 : 1;
			f[ch - 'a'] = Math.max(f[ch - 'a'], k);
		}

		int total = 0;
		for (int cnt : f) {
			total += cnt;
		}
		return total;
	}

}
