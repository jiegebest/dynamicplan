package sort;

/**
 * 注意每次是 bigger 跟另外的数比较
 * 构建
 * 堆顶移至堆尾，然后遍历到头，排好序
 */
public class 堆排序 {

	public int[] sortArray(int[] nums) {
		int n = nums.length;
		buildMaxHeap(nums, n);
		for (int i = n - 1; i > 0; --i) {
			swap(nums, 0, i);
			adjust(nums, 0, i);
		}
		return nums;
	}

	public void buildMaxHeap(int[] nums, int n) {
		for (int i = n / 2 - 1; i >= 0; --i) {
			adjust(nums, i, n);
		}
	}

	public void adjust(int[] nums, int i, int n) {
		if (i >= n - 1) {
			return;
		}
		int bigger = i, left = i * 2 + 1, right = left + 1;
		if (left < n && nums[bigger] < nums[left]) {
			bigger = left;
		}
		if (right < n && nums[bigger] < nums[right]) {
			bigger = right;
		}
		if (i != bigger) {
			swap(nums, i, bigger);
		}
		adjust(nums, left, n);
		adjust(nums, right, n);
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
