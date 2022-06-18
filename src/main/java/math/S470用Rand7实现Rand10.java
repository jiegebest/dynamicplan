package math;

/**
 *  1-7 -> 0-6
 *  7 进制
 *  7 * [0-6] + [0-6] -> [0, 42] 之间均匀分布
 *
 *  答案取 [1, 10]  -> [0, 9] 因此将 42 取整，[0, 40] % 10 = [0, 9]最后再加一个 1 -> [1, 10]
 *
 * 感觉第一份代码当成模拟 7 进制好理解些，把 rand7() 的值减 1 ，就成了 [0, 6]，模拟两位的 7 进制数，取 [0, 39] 范围内的值，对 10 取余后加一
 */
public class S470用Rand7实现Rand10 {

	final int BASE = 7;

	public int rand10() {
		int ans = 0;
		do {
			int a = rand7() - 1;
			int b = rand7() - 1;
			ans = a * BASE + b;
		} while (ans >= 40);
		return  1 + ans % 10;
	}

	public int rand7() {
		return 1;
	}

}


