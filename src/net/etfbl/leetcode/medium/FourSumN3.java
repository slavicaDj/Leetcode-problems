package net.etfbl.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSumN3 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
		
		
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				int k = j + 1;
				int l = nums.length - 1;
				
				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					
					if (sum > target)
						l--;
					else if (sum < target)
						k++;
					else {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						list.add(nums[l]);
						resultSet.add(list);
						
						k++;
						l--;
					}
				}
			}
		}
		
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		resultList.addAll(resultSet);
		return resultList;
	}
	
	public static void main(String[] args) {
		FourSumN3 fs = new FourSumN3();
		int[] nums = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> lists = fs.fourSum(nums, 0);
		lists.forEach(System.out::println);
	}
}
