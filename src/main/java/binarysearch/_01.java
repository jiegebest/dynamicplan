package binarysearch;

/**
 * 一堆负数，一堆 0，一堆正数，找出最后一个负数和第一个正数
 * 找最左 0 和最右 0
 * -1 -2 -3 0 0 0 1 2 3
 * 找小于 0 最大的数，找小于 1 最大的数
 */
public class _01 {

	public int[] search(int[] nums) {
		int left = binarySearch(nums, 0);
		int right = binarySearch(nums, 1);
		return new int[]{nums[left], nums[right + 1]};
	}

	// 接近 target 最大的数
	public int binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left + 1 < right) {
			int mid = (left + right) >> 1;
			if (nums[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return nums[right] < target ? right : left;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{-3, -5, -7, 0, 0, 0, 1, 4, 8};
		int[] res = new _01().search(arr);
		for (int num : res) {
			System.out.println(num);
		}
	}

}
