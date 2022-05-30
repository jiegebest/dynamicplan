package 依赖前一个状态99.区间13.括号2;

/**
 * 最大值 = max / min
 * 最小值 = min / max
 * 最后还要输出str,所以也带上
 */
public class S553最优除法 {

	public String optimalDivision(int[] nums) {
		int n = nums.length;
		Node[][] f = new Node[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; ++j) {
				f[i][j] = new Node();
			}
		}
		for (int i = 0; i < n; ++i) {
			f[i][i].max = f[i][i].min = nums[i];
			f[i][i].maxStr = f[i][i].minStr = String.valueOf(nums[i]);
		}

		for (int i = n - 2; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				for (int k = i; k < j; ++k) {
					double max = f[i][k].max / f[k + 1][j].min;
					double min = f[i][k].min / f[k + 1][j].max;
					if (max > f[i][j].max) {
						f[i][j].max = max;
						if (k + 1 == j) {
							f[i][j].maxStr = f[i][k].maxStr + "/" + f[k + 1][j].minStr;
						} else {
							f[i][j].maxStr = f[i][k].maxStr + "/(" + f[k + 1][j].minStr + ")";
						}
					}
					if (min < f[i][j].min) {
						f[i][j].min = min;
						if (k + 1 == j) {
							f[i][j].minStr = f[i][k].minStr + "/" + f[k + 1][j].maxStr;
						} else {
							f[i][j].minStr = f[i][k].minStr + "/(" + f[k + 1][j].maxStr + ")";
						}
					}
				}
			}
		}
		return f[0][n - 1].maxStr;
	}

}

class Node {
	double max = Integer.MIN_VALUE;
	double min = Integer.MAX_VALUE;
	String maxStr = "";
	String minStr = "";

	public Node() {
	}
}
