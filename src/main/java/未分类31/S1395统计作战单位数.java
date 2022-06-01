package 未分类31;

public class S1395统计作战单位数 {

	/**
	 枚举中间点
	 */
	public int numTeams(int[] rating) {
		int ans = 0, n = rating.length;
		for (int i = 1; i < n - 1; ++i) {
			int leftLess = 0, leftMore = 0;
			int rightLess = 0, rightMore = 0;
			for (int j = 0; j < i; ++j) {
				if (rating[j] < rating[i]) {
					leftLess++;
				} else if (rating[j] > rating[i]) {
					leftMore++;
				}
			}
			for (int j = i + 1; j < n; ++j) {
				if (rating[j] < rating[i]) {
					rightLess++;
				} else if (rating[j] > rating[i]) {
					rightMore++;
				}
			}
			ans += leftLess * rightMore + leftMore * rightLess;
		}
		return ans;
	}

}
