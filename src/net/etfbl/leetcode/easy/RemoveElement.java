package net.etfbl.leetcode.easy;

import java.util.Arrays;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
	   int k = -1;
	   for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) nums[++k] = nums[i];
	   }
	   return k + 1;
	}

	public static void main(String[] args) {
		// without streams - calling method, additional lines
		int[] arr = {2, 2, 3, 3, 4};
		RemoveElement re = new RemoveElement();
		int len = re.removeElement(arr, 2);
		Arrays.stream(arr).limit(len).forEach(System.out::print);
		
		System.out.println();
		
		// with streams - without extra method
		int[] arr2 = {2, 2, 3, 3, 4};
		arr2 = Arrays.stream(arr2).filter(el -> el != 2).toArray();
		Arrays.stream(arr2).forEach(System.out::print);
	}
}
