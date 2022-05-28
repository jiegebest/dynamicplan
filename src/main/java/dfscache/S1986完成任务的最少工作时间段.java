package dfscache;

public class S1986完成任务的最少工作时间段 {

	int ans;

	public int minSessions(int[] tasks, int sessionTime) {
		ans = tasks.length + 1; // 上限
		backtrack(tasks, 0, new int[tasks.length], sessionTime, 0);
		return ans;
	}
	// idx:当前待分配tasks的索引 taskTime:分配情况 cur:当前花费的时间段总数
	public void backtrack(int[] tasks, int idx, int[] taskTime, int sessionTime, int cur) {
		if(cur >= ans) return ; // 剪枝
		if(idx == tasks.length) {   // 更新结果 此时cur一定比ans小
			ans = cur;
			return ;
		}
		boolean flag = false;
		for(int i = 0; i < taskTime.length; ++i) {
			if(taskTime[i] == 0 && flag) break; // 第一个0即可
			if(taskTime[i] + tasks[idx] > sessionTime) continue;    // 超时
			if(taskTime[i] == 0) {
				flag = true;    // 开辟新的工作时间段
			}
			taskTime[i] += tasks[idx];
			backtrack(tasks, idx + 1, taskTime, sessionTime, flag ? cur + 1 : cur); // 开辟新时间段时 cur+1
			taskTime[i] -= tasks[idx];
		}
	}

}
