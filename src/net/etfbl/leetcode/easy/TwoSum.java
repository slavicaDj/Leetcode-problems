package net.etfbl.leetcode.easy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
    	 Map<Integer, Integer> map = new HashMap<>();
         for (int i = 0; i < nums.length; i++)
         	map.put(nums[i], i);
         	
         for (int i = 0; i < nums.length; i++) {
         	int match = target - nums[i];
         	/* map will return the latest appearing duplicate, if any */
         	/* but by definition, there can only be two of them */
         	int index = -1;
             if (map.containsKey(match))
                 index = map.get(match);

         	if (index != -1 && index != i) {
         		int[] indices = new int[2];
         		indices[0] = i;
         		indices[1] = index;
         		return indices;
         	}
         }
         return null;
        
    }
    
    
    public static void main(String[] args) {
    	int[] arr = {3, 3, 3};
    	TwoSum twoSum = new TwoSum();
    	int[] indices = twoSum.twoSum(arr, 6);
    	System.out.println(indices[0] + " " + indices[1]);
    }
}