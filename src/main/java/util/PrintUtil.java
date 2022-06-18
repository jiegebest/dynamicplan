package util;

public class PrintUtil {

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int a = Integer.MAX_VALUE + 1;
		System.out.println(a);
	}

}
