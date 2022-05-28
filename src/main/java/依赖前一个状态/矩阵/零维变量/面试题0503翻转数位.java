package 依赖前一个状态.矩阵.零维变量;

/**
 * 1 << 31 第32位为1是最小的负数
 */
public class 面试题0503翻转数位 {

	public int reverseBits(int num) {
		int curr = 0, total = 0, max = 1;
		for (int i = 0; i < 32; ++i) {
			if ((num & (1 << i)) == 0) {
				total = curr + 1;
				curr = 0;
			} else {
				total++;
				curr++;
			}
			max = Math.max(max, total);
		}
		return max;
	}

}
