package dp.依赖前特定状态5.区间集合;

import java.util.Arrays;

/**
 * f[i] 代表区间 [0,i] 最小子区间数量 0~time
 */
public class S1024视频拼接 {

	static final int INF = Integer.MAX_VALUE / 2;

	public int videoStitching(int[][] clips, int time) {
		int[] f = new int[time + 1];
		Arrays.fill(f, INF);
		f[0] = 0;

		for (int i = 1; i <= time; ++i) {
			for (int[] clip : clips) {
				if (clip[0] <= i && i <= clip[1]) {
					f[i] = Math.min(f[i], f[clip[0]] + 1);
				}
			}
		}

		return f[time] == INF ? -1 : f[time];
	}

}
