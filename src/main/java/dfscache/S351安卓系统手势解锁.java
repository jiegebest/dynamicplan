package dfscache;

public class S351安卓系统手势解锁 {

	public int numberOfPatterns(int m, int n) {
		int[][] skip = new int[10][10];
		//这个skip数组是为了记录跳跃的点数，比如说从1到3，就跳跃2
		//而且因为是对称的操作，所以3到1也是如此
		skip[1][3] = skip[3][1] = 2;
		skip[1][7] = skip[7][1] = 4;
		skip[3][9] = skip[9][3] = 6;
		skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = 5;
		skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5;
		skip[7][9] = skip[9][7] = 8;
		int result = 0;
		boolean[] visited = new boolean[10];
		//深度遍历所有情况，即走过的路程分别为 m,m+1,...,n-1,n 时的方法数
		for(int i = m; i<=n; ++i){
			// 为什么 i 要减一呢，因为我们是从 i 出发，即出发也算走了一步
			//因为从1,3,7,9出发都是对称的
			result += DFS(1,visited,skip,i-1)*4;
			//2,4,6,8对称
			result += DFS(2,visited,skip,i-1)*4;
			//唯独5独立
			result += DFS(5,visited,skip,i-1);
		}
		return result;
	}

	/**
	 *
	 * @param current   起点
	 * @param visited   保存所有点是否走过的布尔数组
	 * @param skip      记录两点之间是否存在其他点的二维数组
	 * @param remainKeyCount    剩余可走步数
	 * @return
	 */
	public int DFS(int current, boolean []visited, int [][]skip,int remainKeyCount){
		if(remainKeyCount == 0){
			return 1;
		}
		int result = 0; // 从这个点开始，往后走完 remainKeyCount 的所有可能情况数
		visited[current] = true;    // 当前点已经走过了
		// 遍历 current 的下一步所有的可能目标
		for(int i = 1; i <= 9; ++i){
			// 看当前的节点到i节点的路径中有没有其他节点在中间
			int crossThroughNumber = skip[current][i];
			// 如果这一次我们的i节点没有被读过，如果读过，就忽略这个点
			// 如果没用过，看能不能走过去
			// 即判断有没有路过中间节点(visited[crossThroughNumber])或者这两个节点相邻没有中间节点（currentThrough=0）
			if(!visited[i] && (crossThroughNumber == 0 ||visited[crossThroughNumber])){
				// current 点已经处理好，剩下的路就交给 i 点了，已走了一步，因此 remainKeyCount-1
				result += DFS(i,visited,skip,remainKeyCount-1);
			}
		}
		visited[current] = false;   // 已经统计好 current 往下走的所有可能情况数，重置为 false
		return result;
	}

}
