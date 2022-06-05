package dp.依赖前一个状态99.过程模拟1;

/**
 * 注意：每一轮的改变必须同时改变
 */
public class S838推多米诺 {

	/**
	 * 将大区间拆解为多个小区间，统一判断
	 * 如果左右同向，一边倒
	 * 如果左右反向，不动
	 * 如果左右相向，向中间倒
	 */
	public String pushDominoes(String dominoes) {
		char[] arr = dominoes.toCharArray();
		int n = arr.length;
		char left = 'L';
		int i  = 0;
		while (i < n) {
			int j = i;
			while (j < n && arr[j] == '.') {
				++j;
			}
			char right = j == n ? 'R' : arr[j];
			if (left == right) {
				while (i < j) {
					arr[i++] = right;
				}
			} else if (left == 'R' && right == 'L') {
				int k = j - 1;
				while (i < k) {
					arr[i++] = 'R';
					arr[k--] = 'L';
				}
			}
			i = j + 1;
			left = right;
		}
		return new String(arr);
	}


	/**
	 * 一步一步模拟，最好理解的。
	 */
	// public String pushDominoes(String dominoes) {
	// 	char[] arr = dominoes.toCharArray();
	// 	int n = arr.length;
	// 	if (n == 1) {
	// 		return dominoes;
	// 	}
	// 	while (true) {
	// 		int mod = 0;
	// 		char[] clone = new char[n];
	// 		for (int i = 0; i < n; ++i) {
	// 			if (arr[i] != '.') {
	// 				continue;
	// 			}
	// 			if (i == 0) {
	// 				if (arr[1] == 'L') {
	// 					clone[0] = 'L';
	// 					++mod;
	// 				}
	// 			} else if (i == n - 1) {
	// 				if (arr[n - 2] == 'R') {
	// 					clone[n - 1] = 'R';
	// 					++mod;
	// 				}
	// 			} else {
	// 				if (arr[i - 1] == 'R' && (arr[i + 1] == 'R' || arr[i + 1] == '.')) {
	// 					clone[i] = 'R';
	// 					++mod;
	// 				} else if ((arr[i - 1] == 'L' || arr[i - 1] == '.') && arr[i + 1] == 'L') {
	// 					clone[i] = 'L';
	// 					++mod;
	// 				}
	// 			}
	// 		}
	// 		if (mod == 0) {
	// 			break;
	// 		}
	// 		for (int i = 0; i < n; ++i) {
	// 			if (clone[i] != '\u0000') {
	// 				arr[i] = clone[i];
	// 			}
	// 		}
	// 	}
	// 	return new String(arr);
	// }

}
