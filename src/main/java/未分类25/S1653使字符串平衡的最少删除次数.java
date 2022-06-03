package 未分类25;

public class S1653使字符串平衡的最少删除次数 {

	public int minimumDeletions(String s) {
		int n = s.length();
		int[] rightB = new int[n+1];
		for(int i = n-1; i >= 0; --i){
			rightB[i]=rightB[i+1];
			if(s.charAt(i)=='b')
				++rightB[i];
		}

		int maxLen = 0;
		int leftA = 0;
		for(int i = 0; i < n; ++i){
			maxLen = Math.max(maxLen,leftA+rightB[i]);
			if(s.charAt(i)=='a')
				++leftA;
		}
		maxLen = Math.max(maxLen,leftA);

		return n-maxLen;
	}

}
