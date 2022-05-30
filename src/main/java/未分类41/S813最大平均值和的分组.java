package 未分类41;

public class S813最大平均值和的分组 {

	public double largestSumOfAverages(int[] A, int K) {
		int N = A.length;
		double[] P = new double[N+1];
		for (int i = 0; i < N; ++i)
			P[i+1] = P[i] + A[i];

		double[] f = new double[N];
		for (int i = 0; i < N; ++i)
			f[i] = (P[N] - P[i]) / (N - i);

		for (int k = 0; k < K-1; ++k)
			for (int i = 0; i < N; ++i)
				for (int j = i+1; j < N; ++j)
					f[i] = Math.max(f[i], (P[j]-P[i]) / (j-i) + f[j]);

		return f[0];
	}

}
