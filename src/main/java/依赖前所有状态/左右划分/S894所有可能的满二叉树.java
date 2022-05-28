package 依赖前所有状态.左右划分;

import 未分类.basic.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S894所有可能的满二叉树 {

	public List<TreeNode> allPossibleFBT(int n) {
		if (n % 2 == 0) {
			return new ArrayList();
		}

		Map<Integer, List<TreeNode>> map = new HashMap<>();
		TreeNode root = new TreeNode(0);
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		map.put(1, list);

		for (int i = 3; i <= n; i += 2) {
			list = new ArrayList<>();
			for (int j = 1; j < i; j += 2) {
				for (TreeNode node1 : map.get(j)) {
					for (TreeNode node2 : map.get(i - 1 - j)) {
						TreeNode node = new TreeNode(0);
						node.left = node1;
						node.right = node2;
						list.add(node);
					}
				}
			}
			map.put(i, list);
		}
		return map.get(n);
	}

}
