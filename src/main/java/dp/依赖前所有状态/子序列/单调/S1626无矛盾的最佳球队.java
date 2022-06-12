package dp.依赖前所有状态.子序列.单调;

import java.util.Arrays;

/**
 * 本题的数据范围显然不可能支持我们进行所有子集的枚举。
 * 按照年龄升序进行排序, 年龄相同时，则按照分数升序进行排序。
 * dp[i] 表示最后一个队员是第i个队员时的最大分数（这里的 ii 是重新排序后的编号）
 * 只需要在 [0,i-1]的范围内枚举上一个队员即可。
 *
 * 两个一维数组，转为二维数组，然后排序，很精妙
 *
 * 如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾
 * 所以年龄小的，成绩<=年龄大的分数
 *
 * 排序后，就不需要考虑年龄了，因为分值的前后顺序，就已经约束了年龄的大小关系。
 * 也就是后面分值比前面分值大于等于，就约束了，年龄不管一样不一样，都是满足大的年龄分值一定大于等于小的年龄。
 *
 * 需要对前面所有分值较小的结果做最大值的比较和 max 取值，所以比较完以后，取到一个最大值
 */
public class S1626无矛盾的最佳球队 {

	public int bestTeamScore(int[] scores, int[] ages) {
		int n = scores.length;
		int[][] f = new int[n][2];
		for (int i = 0; i < n; ++i) {
			f[i][0] = ages[i];
			f[i][1] = scores[i];
		}
		Arrays.sort(f, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		int[] grades = new int[n];
		for (int i = 0; i < n; ++i) {
			grades[i] = f[i][1];
		}

		int ans = 0;
		for (int i = 0; i < n; ++i) {
			int max = 0;
			for (int j = 0; j < i; ++j) {
				if (f[j][1] <= f[i][1]) {
					max = Math.max(max, grades[j]);
				}
			}
			grades[i] = max + f[i][1];
			ans = Math.max(ans, grades[i]);
		}
		return ans;
	}

}
