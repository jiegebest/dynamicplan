package 依赖前一个状态99.状态机18.连续1;

/**
 翻转-0
 不翻转-1
 */
public class 面试题0503翻转数位 {

	public int reverseBits(int num) {
		int[][] f = new int[33][2];
		int max = 0;
		for (int i = 1; i <= 32; ++i) {
			if ((num & (1 << (i - 1))) == 0) {
				f[i][0] = 0;
				f[i][1] = f[i - 1][0] + 1;
			} else {
				f[i][0] = f[i - 1][0] + 1;
				f[i][1] = f[i - 1][1] + 1;
			}
			max = Math.max(max, f[i][1]);
		}
		return max;
	}

}
