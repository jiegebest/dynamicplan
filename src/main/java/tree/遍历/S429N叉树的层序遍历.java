package tree.遍历;

import util.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S429N叉树的层序遍历 {

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> rows = new ArrayList<>();
		if (root == null) {
			return rows;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> row = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				Node curr = queue.poll();
				row.add(curr.val);
				for (Node child : curr.children) {
					queue.offer(child);
				}
			}
			rows.add(row);
		}

		return rows;
	}

}
