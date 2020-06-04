package net.etfbl.leetcode.medium;

public class MaxKSumOpt {
	
	public static int getMaxSum(int[] arr, int k) {
		int max_sum = 0, window_sum = 0; /* calculate sum of 1st window */
		for (int i = 0; i < k; i++)  window_sum += arr[i]; /* slide window from start to end in array. */
		System.out.println("window_sum initial: " + window_sum);
		 
		for (int i = k; i < arr.length; i++){
			System.out.println("we are adding " + arr[i] + " - " + arr[i - k] + " to the window sum");
			System.out.println("arr[i]: " + arr[i]);
			System.out.println("arr[i - k]: " + arr[i - k]);
			System.out.println("previous window sum: " + window_sum);
		    window_sum += arr[i] - arr[i - k];    // saving re-computation
		    System.out.println("new window sum: " + window_sum);
		    max_sum = Math.max(max_sum, window_sum);
		    System.out.println("---------------");
		}
		
		return max_sum;
	}
	
	public static void main(String[] args) {
		int[] arr = {100, 200, 300, 400};
		System.out.println(getMaxSum(arr, 2));
	}

}
