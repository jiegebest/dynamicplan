package dp.依赖前一个状态.状态机.奇偶1;

/**
 奇数下标元素的和 = 偶数下标元素的和
 状态机：奇偶 左右

 删除元素后，左边奇偶位之和不变，右边奇偶位之和互换
 一次遍历即可
 */
public class S1664生成平衡数组的方案数 {

	public int waysToMakeFair(int[] nums) {
		int n = nums.length;
		int rightOddSum = 0, rightEvenSum = 0;
		for (int i = 0; i < n; i += 2) {
			rightOddSum += nums[i];
		}
		for (int i = 1; i < n; i += 2) {
			rightEvenSum += nums[i];
		}
		int sum = rightOddSum + rightEvenSum;

		int cnt = 0, leftOddSum = 0, leftEvenSum = 0;
		for (int i = 0; i < n; ++i) {
			int temp = sum - nums[i];
			if ((i & 1) == 0) {
				rightOddSum -= nums[i];
			} else {
				rightEvenSum -= nums[i];
			}
			if ((temp & 1) == 0 && (leftOddSum + rightEvenSum == leftEvenSum + rightOddSum)) {
				++cnt;
			}
			if ((i & 1) == 0) {
				leftOddSum += nums[i];
			} else {
				leftEvenSum += nums[i];
			}
		}
		return cnt;
	}

}
