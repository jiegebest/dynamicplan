package 未分类25;

import java.util.Arrays;
import java.util.Comparator;

public class S面试题1708马戏团人塔 {

	public int bestSeqAtIndex(int[] height, int[] weight) {
		int len = height.length;
		int[][] person = new int[len][2];
		for (int i = 0; i < len; ++i)
			person[i] = new int[]{height[i], weight[i]};
		Arrays.sort(person, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0]){
					return o1[0]-o2[0];
				}else{
					return o2[1]-o1[1];
				}
			}
		});
		int [] f = new int [person.length];
		int res = 0;
		for(int [] p:person){
			int i=0,j=res;
			while(i<j){
				int mid = i+(j-i)/2;
				if(f[mid]<p[1])    i = mid+1;
				else    j = mid;
			}
			f[i] = p[1];
			if(res==j)  res++;
		}
		return res;
	}

}
