package noalgo;

import java.util.Arrays;

/**
 * 找出数组中每个数的右边第一个比它大的数
 */
public class FindBigger {

	public int[] findFirstBigger(int[] nums) {
		int n = nums.length;
		int[] arr = new int[n];
		Arrays.fill(arr, -1);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[j] > nums[i]) {
					arr[i] = nums[j];
					break;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{7, 3, 9, 2,  8 , 6};
		for (int i : new FindBigger().findFirstBigger(nums)) {
			System.out.println(i);
		}
	}

}
