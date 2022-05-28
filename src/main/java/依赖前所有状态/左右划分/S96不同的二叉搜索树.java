package 依赖前所有状态.左右划分;

public class S96不同的二叉搜索树 {

	// n 跟 1~n-1都有关
	public int numTrees(int n) {
		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 1;

		for (int count = 2; count <= n; count++) {
			int sum = 0;
			for (int left = 0; left < count; left++) {
				// 不同的值作为顶点的区别是,左右子树的节点数分布不同. 跟顶点节点本身的值无关
				// 左子树节点 + 右子树节点 = count - 1(去掉根节点)
				int right = count - 1 - left;
				sum += f[left] * f[right];
			}
			f[count] = sum;
		}
		return f[n];
	}

}
