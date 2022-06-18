package tree.求路径;

import dp.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * dfs
 */
public class S剑指Offer34二叉树中和为某一值的路径 {

	List<List<Integer>> paths = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int target) {
		dfs(root, target);
		return paths;
	}

	public void dfs(TreeNode root, int target) {
		if (root == null) {
			return;
		}

		path.add(root.val);
		target -= root.val;
		if (root.left == null && root.right == null && target == 0) {
			paths.add(new ArrayList<>(path));
		}

		dfs(root.left, target);
		dfs(root.right, target);
		path.remove(path.size() - 1);
	}

}
