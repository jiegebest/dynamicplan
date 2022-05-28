package 依赖前几个状态.统计学规律;

public class S357统计各位数字都不同的数字个数 {

	/**
	 * 单元素也算各位数字都不同 数字的题目就是找规律。。。
	 * 不是对问题进行动态规划，是对规律进行动态规划
	 n = 0 1
	 n = 1 [1] + 9
	 n = 2 [1 + 9] + 9 * (10 - 1) 第二个数不能和第一个数重复
	 n = 3 [1 + 9 + 9 * 9] + 9 * 9 * (10 - 2) 第三个数不能和前两个数重复
	 */
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}

		int a = 1, b = 10;
		for (int i = 2; i <= n; ++i) {
			int temp = b + (b - a) * (10 - (i - 1));
			a = b;
			b = temp;
		}
		return b;
	}

}
