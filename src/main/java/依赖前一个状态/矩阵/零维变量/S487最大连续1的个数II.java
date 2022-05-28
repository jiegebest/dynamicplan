package 依赖前一个状态.矩阵.零维变量;

public class S487最大连续1的个数II {

	public int findMaxConsecutiveOnes(int[] nums) {
		int left = 0, total = 0, max = 0;
		for (int num : nums) {
			if (num == 0) {
				total = left + 1;
				left = 0;
			} else {
				total++;
				left++;
			}
			max = Math.max(max, total);
		}
		return max;
	}

}
