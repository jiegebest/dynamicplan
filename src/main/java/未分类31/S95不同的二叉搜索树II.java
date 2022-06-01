package 未分类31;

import 未分类31.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S95不同的二叉搜索树II {

	// 二叉搜索树 插在右上，或者多个右下，将原来的右下作为新节点的左下
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> prev = new ArrayList<>();
		prev.add(new TreeNode(1));

		for (int i = 2; i <= n; ++i) {
			List<TreeNode> curr = new ArrayList<>();
			for (TreeNode node : prev) {
				// 原树作为新节点的左子树
				TreeNode newNode = new TreeNode(i);
				TreeNode newRoot = treeClone(node);
				newNode.left = newRoot;
				curr.add(newNode);

				// 最多向右查找n-1次
				for (int j = 0; j < n; ++j) {
					newRoot = treeClone(node);
					TreeNode ptr = newRoot;
					for (int k = 0; k < j; ++k) {
						if (ptr == null) {
							break;
						}
						ptr = ptr.right;
					}
					if (ptr == null) {
						break;
					}
					TreeNode temp = ptr.right;
					newNode = new TreeNode(i);
					ptr.right = newNode;
					newNode.left = temp;
					curr.add(newRoot);
				}
			}
			prev = curr;
		}
		return prev;
	}

	public TreeNode treeClone(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode newRoot = new TreeNode(root.val);
		newRoot.left = treeClone(root.left);
		newRoot.right = treeClone(root.right);
		return newRoot;
	}

}
