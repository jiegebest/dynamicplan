package dp.依赖前所有状态.应用题;

/**
 * f[i]表示以第i-1本书（从第0本算起）结尾的前i本书叠成的最小高度
 */
public class S1105填充书架 {

	public int minHeightShelves(int[][] books, int shelf_width) {
		int n = books.length;
		int[] f = new int[n+1];
		f[1] = books[0][1];

		for(int i = 2; i <= n; ++i) {
			// 当第i本书单独作为一层时
			f[i] = books[i - 1][1] + f[i - 1];
			int w = books[i - 1][0], h = books[i - 1][1];
			for (int j = i - 1; j > 0; j--) {
				// 当第i本书和第i-1本书一起作为一层的时候，dp[i] = dp[i-2] + max(books[i-1][1], books[i-2][1])
				w += books[j - 1][0];
				if (w > shelf_width) {
					break;
				}
				h = Math.max(h, books[j - 1][1]);
				f[i] = Math.min(f[i], f[j - 1] + h);
			}
		}
		return f[n];
	}

}
