package 依赖前特定规则状态.一半;

public class S397整数替换 {

	public int integerReplacement(int n) {
		if (n == 1) {
			return 0;
		}
		if (n % 2 == 0) {
			return 1 + integerReplacement(n / 2);
		}
		return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
	}

}
