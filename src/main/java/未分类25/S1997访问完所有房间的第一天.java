package 未分类25;

public class S1997访问完所有房间的第一天 {

	int mod = (int) 1e9 + 7;

	public int firstDayBeenInAllRooms(int[] nextVisit) {
		int n = nextVisit.length;
		long[] d1 = new long[n];// 第一次奇数抵达的日期
		long[] d2 = new long[n];// 第一次偶数抵达的日期
		d1[0] = 0;
		d2[0] = 1;
		for (int i = 1; i < n; ++i) {
			// 第一次抵达i位置，是第二次抵达i-1位置日期 + 1
			d1[i] = d2[i - 1] + 1;// 第一次奇数抵达的日期
			// 再次回到i = 第一次到达i时间 + 1天（返回next）+ mod补正 + 第一次抵达next至今的时间差
			d2[i] = d1[i] + 1 + d1[i] + mod - d1[nextVisit[i]];
			d1[i] %= mod;
			d2[i] %= mod;
		}
		return (int) d1[n - 1];
	}

}
