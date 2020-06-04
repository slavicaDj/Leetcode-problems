package net.etfbl.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int partialSum = nums[i] + nums[j] + nums[k];
					int key = target - partialSum;
					int index = Arrays.binarySearch(nums, k + 1, nums.length, key);
					if (index >= 0) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						list.add(nums[index]);
						set.add(list);
					}
				}
			}
		}
		
//		List<List<Integer>> lists = new ArrayList<List<Integer>>();
//		lists.addAll(set);
//		return lists;
		
		return set.stream().collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		FourSum fs = new FourSum();
		int[] nums = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> lists = fs.fourSum(nums, 0);
		lists.forEach(System.out::println);
	}
}
