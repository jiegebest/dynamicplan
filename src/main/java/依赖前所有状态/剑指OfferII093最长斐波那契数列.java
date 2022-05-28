package 依赖前所有状态;

/**
 * f+双指针
 */
public class 剑指OfferII093最长斐波那契数列 {

	// 1+2=3[3个数] 2+3=5[4个数] 3+5=8[5个数] 所以依赖需要保留第二个加数以及和,以便下一个依赖使用 f2,3 f3,5 f5,8
	// i + j = k 代表第i,j,k个数，要比下标多1
	public int lenLongestFibSubseq(int[] arr) {
		int n = arr.length, max = 0;
		int[][] f = new int[n + 1][n + 1];
		for (int k = 3; k <= n; ++k) {
			int i = 1, j = k - i;
			while (i < j) {
				if (arr[i - 1] + arr[j - 1] == arr[k - 1]) {
					f[j][k] = f[i][j] == 0 ? 3 : f[i][j] + 1;
					max = Math.max(max, f[j][k]);
					++i;
					j--;
				} else if (arr[i - 1] + arr[j - 1] < arr[k - 1]) {
					++i;
				} else {
					j--;
				}
			}
		}
		return max;
	}

}
