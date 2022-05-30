package 未分类41;

import java.util.Arrays;

public class S1578使绳子变成彩色的最短时间 {

	public int minCost(String s, int[] cost) {
		int n = cost.length;
		//f[i][j]表示子串s[0..i]，并且以字符j结尾的最小成本, 其中f[i][26]表示为空串的成本
		int[][] f = new int[n][27];
		Arrays.fill(f[0], Integer.MAX_VALUE);
		f[0][s.charAt(0) - 'a'] = 0;
		f[0][26] = cost[0];

		for(int i = 1; i < n; ++i){
			for(int j = 0; j < 27; ++j){
				//特殊处理一下26
				if(j == 26){
					f[i][j] = f[i - 1][j] + cost[i];
					continue;
				}
				int num = s.charAt(i) - 'a';
				f[i][j] = Integer.MAX_VALUE;
				if(num == j){
					//字符相同，那么可能保留当前字符，也可能删除当前字符
					//1、删除当前字符
					if(f[i - 1][j] != Integer.MAX_VALUE){
						f[i][j] = f[i - 1][j] + cost[i];
					}
					//2、保留当前字符，那么枚举前面的字符
					for(int k = 0; k < 27; ++k){
						if (j != k) {
							f[i][j] = Math.min(f[i][j], f[i - 1][k]);
						}
					}

				}else{
					//字符不同，那么当前字符必须删掉
					if(f[i - 1][j] != Integer.MAX_VALUE){
						f[i][j] = f[i - 1][j] + cost[i];
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for(int j = 0; j < 26; ++j){
			min = Math.min(min, f[n - 1][j]);
		}
		return min;
	}

}
