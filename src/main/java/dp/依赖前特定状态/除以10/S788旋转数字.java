package dp.依赖前特定状态.除以10;

/**
 0代表旋转后仍是自己，1代表是好数，-1代表不是好数
 */
public class S788旋转数字 {

	public int rotatedDigits(int n) {
		int[] f = new int[n + 1];
		int cnt = 0;
		for (int i = 1; i <= n; ++i) {
			int prev = f[i / 10];
			int rest = i % 10;
			if (prev == 1) {
				f[i] = isBadDigit(rest) ? -1 : 1;
			} else if (prev == -1) {
				f[i] = -1;
			} else {
				if (isBadDigit(rest)) {
					f[i] = -1;
				} else {
					f[i] = isGoodDigit(rest) ? 1 : 0;
				}
			}
			if (f[i] == 1) {
				++cnt;
			}
		}
		return cnt;
	}

	public boolean isGoodDigit(int num) {
		return num == 2 || num == 5 || num == 6 || num == 9;
	}

	public boolean isBadDigit(int num) {
		return num == 3 || num == 4 || num == 7;
	}

}
