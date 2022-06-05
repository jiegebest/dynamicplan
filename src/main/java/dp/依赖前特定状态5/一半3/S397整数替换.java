package dp.依赖前特定状态5.一半3;

public class S397整数替换 {

	public int integerReplacement(int n) {
		if (n == 1) {
			return 0;
		}
		int half = n / 2;
		if (n % 2 == 0) {
			return 1 + integerReplacement(half);
		}
		return 2 + Math.min(integerReplacement(half), integerReplacement(half + 1));
	}

}