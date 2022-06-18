package math;

/**
 * rand5() 1-5
 * rand5() - 1 = 0-4
 * 5进制
 * 5 * (rand5() - 1) + rand5() - 1 = 0-24
 * % 7
 * 0-6 7-13 14-20 取 0-20的数
 *
 * 1-7 = 1 + 0-6
 *
 */
public class S470用Rand5实现Rand7 {

	final int BASE = 5;

	public int rand10() {
		int ans = 0;
		do {
			int a = rand5() - 1;
			int b = rand5() - 1;
			ans = a * BASE + b;
		} while (ans >= 21);
		return 1 + ans % 7;
	}

	public int rand5() {
		return 1;
	}

}
