package memo.binarytree;

import dp.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 左右划分
 */
public class S95不同的二叉搜索树II {

	public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> allTrees = new ArrayList<>();
		if (start > end) {
			allTrees.add(null);
			return allTrees;
		}

		for (int val = start; val <= end; ++val) {
			List<TreeNode> leftTrees = generateTrees(start, val - 1);
			List<TreeNode> rightTrees = generateTrees(val + 1, end);
			for (TreeNode leftTree : leftTrees) {
				for (TreeNode rightTree : rightTrees) {
					TreeNode root = new TreeNode(val);
					root.left = leftTree;
					root.right = rightTree;
					allTrees.add(root);
				}
			}
		}
		return allTrees;
	}

}
