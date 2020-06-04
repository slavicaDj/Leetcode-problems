package net.etfbl.leetcode.medium;

public class MatrixPrintDiagonal {

	public static void main(String [] args) {
//		int[][] mat = new int[][]{{ 1,  2,  3,  4},
//								  { 6,  7,  8,  9},
//		                          { 11, 12, 13, 14},
//		                          { 16, 17, 18, 19}};
		
		int[][] mat = new int[][] {{1,2,3}, 
								   {4,5,6}, 
								   {7,8,9}};

		for (int j = 0; j < mat.length; j++) {
			for (int i = j; i >= 0; i--) {
				System.out.println(mat[i][j - i]);
			}
		}
		
		for (int j = 1; j < mat.length; j++) {
			for (int i = mat.length - 1; i >= j; i--) {
				System.out.println(mat[i][j - i + mat.length - 1]);
			}
		}

	}
}
