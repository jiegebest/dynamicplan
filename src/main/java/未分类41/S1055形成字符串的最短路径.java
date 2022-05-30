package 未分类41;

public class S1055形成字符串的最短路径 {

	public int shortestWay(String source, String target) {
		int slen = source.length();
		int tlen = target.length();

		// 1. 预处理(因为步骤2是倒着动态规划的，最后一个slen需要处理)
		int[][] f = new int[slen + 1][26];
		for (int i = 0; i < 26; ++i) {
			f[slen][i] = slen;
		}
		// 2. 计算每个字符在 source第一次出现的位置
		for (int i = slen - 1; i >= 0; --i) {
			for (int j = 0; j < 26; ++j) {
				if (source.charAt(i) == (j + 'a')) {
					f[i][j] = i;
				} else {
					f[i][j] = f[i + 1][j];
				}
			}
		}
		// 3. 贪心的计算匹配次数
		int count = 0;
		int ti=0;
		while (ti < tlen) {
			++count;
			int startPos = 0;// 从头source的0位置开始重新匹配
			if(f[startPos][target.charAt(ti) - 'a']==slen) return -1;
			while(ti<tlen  && f[startPos][target.charAt(ti) - 'a']!=slen) {
				startPos = f[startPos][target.charAt(ti) - 'a']+1;
				++ti;
			}

		}
		return count;

	}

}
