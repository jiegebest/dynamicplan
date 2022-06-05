package dp.依赖前一个状态99.二维矩阵31.杨辉三角3;

public class S799香槟塔 {

	public double champagneTower(int poured, int query_row, int query_glass) {
		double[][] f = new double[100][100];
		f[0][0] = (double) poured;
		for (int i = 0; i < query_row; ++i) {
			for (int j = 0; j <= i; ++j) {
				double rest = (f[i][j] - 1.0) / 2.0;
				if (rest > 0) {
					f[i + 1][j] += rest;
					f[i + 1][j + 1] += rest;
				}
			}
		}
		return Math.min(1, f[query_row][query_glass]);
	}

}
