package dp.tmp;

/**
 * f 代表以 i 结尾的元音子串个数
 * 统计全域即可得到结果
 *
 * 结果需要累计每一种状态
 */
public class S2063所有子字符串中的元音 {

	public long countVowels(String word) {
		int n = word.length();
		long[] f = new long[n + 1];
		long total = 0;
		for (int i = 1; i <= n; ++i) {
			f[i] = f[i - 1] + (isVowel(word.charAt(i - 1)) ? i : 0);
			total += f[i];
		}
		return total;
	}

	public boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

}
