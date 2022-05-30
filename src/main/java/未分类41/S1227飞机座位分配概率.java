package 未分类41;

public class S1227飞机座位分配概率 {

	public double nthPersonGetsNthSeat(int n) {
		if (n == 1) return 1.0;
		double [] f=new double[n+1];//从下标1开始使用
		f[2]=0.5;
		double sum_f=1.5;
		for(int i=3;i<=n;++i){
			f[i]=(1.0/(double)i)*sum_f;
			sum_f+=f[i];
		}
		return f[n];
	}

}
