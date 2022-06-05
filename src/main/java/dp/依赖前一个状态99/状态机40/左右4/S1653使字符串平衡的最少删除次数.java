package dp.依赖前一个状态99.状态机40.左右4;

/**
 00001111
 bbaaaaabb > [bb]aaaaabb
 左边代价 右边代价
 f 左边全 a 的代价
 g 右边全 b 的代价

 fg 走的是字符中间的缝隙
 */
public class S1653使字符串平衡的最少删除次数 {

	public int minimumDeletions(String s) {
		int n = s.length();
		int[] f = new int[n + 1];
		int[] g = new int[n + 1];
		for (int i = 0; i < n; ++i) {
			if (s.charAt(i) == 'a') {
				g[0]++;
			}
		}

		int min = f[0] + g[0];
		for (int i = 1; i <= n; ++i) {
			if (s.charAt(i - 1) == 'a') {
				g[i] = g[i - 1] - 1;
				f[i] = f[i - 1];
			} else {
				f[i] = f[i - 1] + 1;
				g[i] = g[i - 1];
			}
			min = Math.min(min, f[i] + g[i]);
		}

		return min;
	}

}
