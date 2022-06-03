package 依赖前所有状态25;

import java.util.HashSet;
import java.util.Set;

/**
    f[i] 累计所有0~i 的置位（置为 1）
 */
public class S898子数组按位或操作 {

	public int subarrayBitwiseORs(int[] arr) {
		int n = arr.length;
		Set<Integer> set = new HashSet<>();
		for (int j = 0; j < n; ++j) {
			set.add(arr[j]);
			for (int i = j - 1; i >= 0; --i) {
				// arr[i] 的置位位置包含了 arr[j] 的置位位置，那么无需考虑 arr[j] 的加入与否
				if ((arr[i] | arr[j]) == arr[i]) {
					break;
				}
				// 求值的同时保留积累状态
				arr[i] |= arr[j];
				set.add(arr[i]);
			}
		}
		return set.size();
	}

}
