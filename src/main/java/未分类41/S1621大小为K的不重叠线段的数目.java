package 未分类41;

public class S1621大小为K的不重叠线段的数目 {

	public int numberOfSets(int n, int k) {
		long [][] f = new long[n][k+1];
		for(int i=0;i<n;++i){
			f[i][0]=1;
		}

		long [][] f_pickn = new long[n][k+1];

		for(int i=1;i<k+1;++i){
			for(int j=i;j<n;++j){
				f_pickn[j][i]=f_pickn[j-1][i]+f[j-1][i-1];
				f[j][i]=(f[j-1][i]+f_pickn[j][i])%1000000007;
			}
		}

		return (int)f[n-1][k];
	}

}
