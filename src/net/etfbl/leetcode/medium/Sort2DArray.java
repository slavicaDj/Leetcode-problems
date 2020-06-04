package net.etfbl.leetcode.medium;
import java.util.Arrays;

public class Sort2DArray {

	public void sort(int[][] arr) {
		if (arr == null)
			return;
		if (arr[0] != null && arr[1] == null) {
			Arrays.sort(arr[0]);
			return;
		}

		int n = arr.length * arr[0].length;
		int[] helper = new int[n];
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				helper[k++] =  arr[i][j];
			}
		}
		
		Arrays.sort(helper);
		
		k = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = helper[k++];
			}
		}
	}
	
	public static void main(String [] args) {
		int[][] arr = new int[][]{{ 5, 12, 17, 21, 23},
							  { 1,  2,  4,  6,  8},
							  {12, 14, 18, 19, 27},
							  { 3,  7,  9, 15, 25}};
		Sort2DArray sorter = new Sort2DArray();
		sorter.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
