package net.etfbl.leetcode.hard;

public class MedianOfTwoSortedArrays {
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] nums = new int[length];
        merge(nums1, nums2, nums);
        
        int mid = length / 2;
        if (length % 2 != 0)
        	return nums[mid];
       return (double)(nums[mid] + nums[mid - 1]) / 2;
        
    }
	
	private static void merge(int[] nums1, int[] nums2, int[] nums) {
		int i = 0, j = 0, k = 0;
		
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j])
				nums[k++] = nums1[i++];
			else
				nums[k++] = nums2[j++];
		}
		
		while (i < nums1.length)
			nums[k++] = nums1[i++];
		
		while (j < nums2.length)
			nums[k++] = nums2[j++];
	}
	
	public static void main(String[] args) {
		int[] a = {1, 3};
		int[] b = {2};
		
		System.out.println(findMedianSortedArrays(a, b));
	}
}
