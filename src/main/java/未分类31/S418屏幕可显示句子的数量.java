package 未分类31;

public class S418屏幕可显示句子的数量 {

	public int wordsTyping(String[] sentence, int rows, int cols) {
		int n = sentence.length, ans = 0;
		int[] len = new int[n], next = new int[n];

		for (int i = 0; i < n; ++i) len[i] = sentence[i].length() + 1;
		for (int i = 0; i < n; ++i) {
			int index = i, c = 0, cnt = 0;
			for (; (c += len[index]) <= cols + 1; index = index + 1 < n ? index + 1 : ++cnt - cnt) ;
			next[i] = cnt * 100 + index;
		}

		for (int i = 0, index = 0; i < rows; ++i, ans += next[index] / 100, index = next[index] % 100) ;
		return ans;
	}

}
