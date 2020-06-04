package net.etfbl.leetcode.easy;

public class MaximumSumSubarray {

	/* brute force solution */
	public int maxSubArrayBF(int[] array) {
		int maxSum = Integer.MIN_VALUE;
		
		for (int i = 0; i < array.length; i++) {
			int currSum = array[i];
			maxSum = (currSum > maxSum)? currSum : maxSum;
			
			for (int j = i + 1; j < array.length; j++) {
				currSum += array[j];
				maxSum = (currSum > maxSum)? currSum : maxSum;
			}
		}
		
		return maxSum;
	}
	
	/* credit: leetcode */
	public int maxSubArray(int[] array) {
	    int res = Integer.MIN_VALUE, sum = 0;
	    for (int i = 0; i < array.length; i++) {
	        sum = Math.max(sum, 0) + array[i];
	        res = Math.max(res, sum);
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		MaximumSumSubarray maxSum = new MaximumSumSubarray();
		
		System.out.println(maxSum.maxSubArray(array));
	}
}
