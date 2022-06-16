package sort;

public class S912排序数组 {

	int[] temp;

	public int[] sortArray(int[] nums) {
		int n = nums.length;
		temp = new int[n];
		mergeSort(nums, 0, n - 1);
		return nums;
	}

	public void mergeSort(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = (start + end) >> 1;
		mergeSort(nums, start, mid);
		mergeSort(nums, mid + 1, end);
		merge(nums, start, mid + 1, end);
	}

	public void merge(int[] nums, int start, int mid, int end) {
		int i = start, j = mid, k = 0;
		while (i < mid && j <= end) {
			temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
		}
		while (i < mid) {
			temp[k++] = nums[i++];
		}
		while (j <= end) {
			temp[k++] = nums[j++];
		}
		while (k > 0) {
			--k;
			nums[start + k] = temp[k];
		}
	}

}
