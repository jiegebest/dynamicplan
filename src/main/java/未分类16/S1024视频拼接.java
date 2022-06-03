package 未分类16;

import java.util.Arrays;

public class S1024视频拼接 {

	public int videoStitching(int[][] clips, int time) {
		int[] f = new int[time + 1];
		Arrays.fill(f, Integer.MAX_VALUE - 1);
		f[0] = 0;
		for (int i = 1; i <= time; ++i) {
			for (int[] clip : clips) {
				if (clip[0] < i && i <= clip[1]) {
					f[i] = Math.min(f[i], f[clip[0]] + 1);
				}
			}
		}
		return f[time] == Integer.MAX_VALUE - 1 ? -1 : f[time];
	}

}
