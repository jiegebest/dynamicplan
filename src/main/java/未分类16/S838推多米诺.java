package 未分类16;

/**
 * 坑爹
 */
public class S838推多米诺 {

	// 只跟前一个状态有关 每次循环修改可以修改的状态，直到没有字符被修改
	public String pushDominoes(String dominoes) {
		char[] letters = dominoes.toCharArray();
		int n = letters.length, modCount;
		char[] temp = new char[n];
		do {
			modCount = 0;
			for (int i = 0; i < n; ++i) {
				if (letters[i] != '.') {
					continue;
				}
				if (i == 0) {
					if (n > 1 && letters[i + 1] == 'L') {
						temp[i] = 'L';
						modCount++;
					}
				} else if (i == n - 1) {
					if (letters[i - 1] == 'R') {
						temp[i] = 'R';
						modCount++;
					}
				} else if (letters[i - 1] == 'R' && letters[i + 1] != 'L') {
					temp[i] = 'R';
					modCount++;
				} else if (letters[i + 1] == 'L' && letters[i - 1] != 'R') {
					temp[i] = 'L';
					modCount++;
				}
			}
			// 同时变更
			for (int i = 0; i < n; ++i) {
				if (temp[i] != '\u0000') {
					letters[i] = temp[i];
				}
			}
		} while (modCount != 0);
		return new String(letters);
	}

}
