package sort;

/**
 * pivot 不能取坐标，坐标对应的值会变
 */
public class 快排 {

	public int[] sortArray(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}

	public void quickSort(int[] nums, int i, int j) {
		if (i >= j) {
			return;
		}
		int pivot = nums[(i + j) >> 1], left = i, right = j;
		while (left <= right) {
			while (left <= right && nums[left] < pivot) {
				++left;
			}
			while (left <= right && nums[right] > pivot) {
				--right;
			}
			if (left <= right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				++left;
				--right;
			}
		}
		quickSort(nums, i, right);
		quickSort(nums, left, j);
	}

}
