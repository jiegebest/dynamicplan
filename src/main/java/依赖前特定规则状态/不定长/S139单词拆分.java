package 依赖前特定规则状态.不定长;

import java.util.List;

public class S139单词拆分 {

	public boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		boolean[] f = new boolean[n + 1];
		f[0] = true;
		for (int i = 1; i <= n; ++i) {
			for (String word : wordDict) {
				int j = i - word.length();
				if (j >= 0 && f[j] && word.equals(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}
		return f[n];
	}

}
