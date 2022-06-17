package array;

import java.util.ArrayList;
import java.util.List;

public class 二维矩阵斜着打印 {
	/**
	 * 右下方向
	 */
	public List<Integer> print1(int[][] nums) {
		int m = nums.length, n = nums[0].length;
		List<Integer> res = new ArrayList<>();
		for (int k = 0; k < m; ++k) {
			int i = k, j = 0;
			while (i >= 0 && j >= 0 && j < n) {
				res.add(nums[i--][j++]);
			}
		}
		for (int k = 1; k < n; ++k) {
			int i = m - 1, j = k;
			while (i >= 0 && j >= 0 && j < n) {
				res.add(nums[i--][j++]);
			}
		}
		return res;
	}

	/**
	 * 左下方向
	 */
	public List<Integer> print2(int[][] nums) {
		int m = nums.length, n = nums[0].length;
		List<Integer> res = new ArrayList<>();
		for (int k = 0; k < m; ++k) {
			int i = 0, j = k;
			while (i < m && j >= 0 && j < n) {
				res.add(nums[i++][j--]);
			}
		}
		for (int k = 1; k < n; ++k) {
			int i = k, j = n - 1;
			while (i < m && j >= 0 && j < n) {
				res.add(nums[i++][j--]);
			}
		}
		return res;
	}
}
