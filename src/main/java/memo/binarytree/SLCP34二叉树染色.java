package memo.binarytree;


import dp.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 好题啊
 * 左右分配
 * 染色根节点
 * 左+右 = k-1
 * 不染根节点
 * 左=k，右=k
 * 二叉树的题目其实贼简单，就一步，把根节点和左右子节点的情况考虑完题目就解完了
 * 如果不染色父节点，左右子结点连续染色树上限重置
 * 一个技巧：双重map来构建memo！
 * Map<TreeNode, Map<Integer, Integer>>
 */
public class SLCP34二叉树染色 {

	Map<TreeNode, Map<Integer, Integer>> cache = new HashMap<>();

	public int maxValue(TreeNode root, int k) {
		return getMax(root, k, k);
	}

	public int getMax(TreeNode node, int remain, int k) {
		if (node == null) {
			return 0;
		}

		Map<Integer, Integer> l2Cache;
		if (cache.containsKey(node)) {
			l2Cache = cache.get(node);
			if (l2Cache.containsKey(remain)) {
				return l2Cache.get(remain);
			}
		} else {
			l2Cache = new HashMap<>();
		}

		int max = getMax(node.left, k, k) + getMax(node.right, k, k);
		for (int i = 0; i < remain; ++i) {
			max = Math.max(max, getMax(node.left, i, k) + node.val + getMax(node.right, remain - 1 - i, k));
		}

		l2Cache.put(remain, max);
		cache.put(node, l2Cache);
		return max;
	}

}
