package dp.依赖前所有状态.左右划分;

public class S96不同的二叉搜索树 {

	public int numTrees(int n) {
		int[] f = new int[n + 1];
		f[0] = f[1] = 1;
		for (int i = 2; i <= n; ++i) {
			int sum = 0;
			for (int j = 0; j < i; ++j) {
				sum += f[j] * f[i - 1 - j];
			}
			f[i] = sum;
		}
		return f[n];
	}

}
