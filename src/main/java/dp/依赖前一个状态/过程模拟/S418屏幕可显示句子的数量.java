package dp.依赖前一个状态.过程模拟;

/**
 * 考虑到题目中提到了sentence长度不超过100，所以可以将状态定义成dp[i] = 100 * (int)(是否换行) + 下一行的开始位置。
 * 句子中的单词总量不会超过 100
 *
 * 1. 将句子放在单词数组中
 * 2. 预处理以每个单词开头，当前行能存放的句子个数，以及下一行的开始单词索引
 * 3. 递推
 */
public class S418屏幕可显示句子的数量 {

	public int wordsTyping(String[] sentence, int rows, int cols) {
		int n = sentence.length;
		int[] len = new int[n];
		for (int i = 0; i < n; ++i) {
			len[i] = sentence[i].length();
		}

		int[] f = new int[n];
		for (int i = 0; i < n; ++i) {
			int j = i, currLen = 0, times = 0;
			while (currLen + len[j] <= cols) {
				currLen += len[j] + 1;
				if (++j == n) {
					j = 0;
					++times;
				}
			}
			f[i] = 100 * times + j;
		}

		int cnt = 0, i = 0;
		for (int row = 0; row < rows; ++row) {
			cnt += f[i] / 100;
			i = f[i] % 100;
		}
		return cnt;
	}

}
