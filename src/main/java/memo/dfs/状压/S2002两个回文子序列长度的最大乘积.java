package memo.dfs.状压;

import java.util.ArrayList;
import java.util.List;

/**
 * 2 <= s.length <= 12 状态压缩
 * 看到数据量只有12，就只能想到状态压缩下的暴力了
 * 枚举所有状态，判断每个状态是不是回文串，计算回文串的长度，选出一个 max
 * 不相交就是用枚举做一个&操作
 * 两层循环直接去判断，但是发现超出了时间复杂度了 因此需要先把状态和长度放入list容器然后再不断取值去判断状态是不是相交
 *
 * 1. 状压 DP，将所有子序列子集枚举出来
 * 2. 将子集转化为字符串，判断是否为回文
 * 3. 将回文和长度添加到 list，然后取笛卡尔积，如果&=0，说明不想交，取 max 的最大值
 *
 * 1. 状压 DP，将所有子序列子集枚举出来
 * 2. 将子集转化为字符串，判断是否为回文
 * 3. 将回文和长度添加到 list，然后取笛卡尔积，如果&=0，说明不想交，取 max 的最大值
 */
public class S2002两个回文子序列长度的最大乘积 {

	public int maxProduct(String s) {
		int[] f = new int[1 << s.length()];
		List<int[]> list = new ArrayList<>();
		for (int i = 1; i < f.length; ++i) {
			String str = getStr(s, i);
			if (isPalindrome(str)) {
				list.add(new int[]{i, str.length()});
			}
		}

		int max = 0;
		for (int i = 0; i < list.size(); ++i) {
			for (int j = i + 1; j < list.size(); ++j) {
				int[] arr1 = list.get(i);
				int[] arr2 = list.get(j);
				if ((arr1[0] & arr2[0]) == 0) {
					max = Math.max(max, arr1[1] * arr2[1]);
				}
			}
		}
		return max;
	}

	// 判断是不是回文，反向取出也没关系
	public String getStr(String s, int bits) {
		int i = s.length() - 1;
		StringBuilder sb = new StringBuilder();
		while (bits != 0) {
			if ((bits & 1) == 1) {
				sb.append(s.charAt(i));
			}
			--i;
			bits >>= 1;
		}
		return sb.toString();
	}

	public boolean isPalindrome(String str) {
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left++) != str.charAt(right--)) {
				return false;
			}
		}
		return true;
	}

}
