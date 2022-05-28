package 依赖前几个状态.打家劫舍;

public class S198打家劫舍 {

	public int rob(int[] nums) {
		int a = 0, b = 0;
		for (int num : nums) {
			int temp = Math.max(b, a + num);
			a = b;
			b = temp;
		}
		return b;
	}

}
