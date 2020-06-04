package net.etfbl.leetcode.easy;

public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		int k = -1;
		int length = nums.length;

		for (int i = 0; i < length;) {
			// last element, just add it
			if (i == length - 1) {
				nums[++k] = nums[i];
				return k + 1;
			}
			
			int j = i;
			
			// duplicates
			while (nums[j] == nums[j + 1]) {
				j++;
				
				if (j == length - 1) {
					nums[++k] = nums[j];
					return k + 1;
				}
			}
			
			if (i == j) {
				nums[++k] = nums[i++];
				continue;
			}
			
			// i != j
			nums[++k] = nums[i];
			i = j + 1;
		}
		
		return k + 1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 3};
		RemoveDuplicates rd = new RemoveDuplicates();
		int k = rd.removeDuplicates(arr);
//		System.out.println(k);
		
		for (int i = 0; i < k; i++) {
			System.out.println(arr[i]);
		}
	}
}
