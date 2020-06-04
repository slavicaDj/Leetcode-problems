package net.etfbl.leetcode.medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSumOpt {
	
    public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> threeSums = new ArrayList<List<Integer>>();
    	HashSet<Pair> pairs = new HashSet<>();

    	Arrays.sort(nums);
    	
    	for (int i = 0; i < nums.length - 2; i++) {
    		int pivot = nums[i];
    		int j = i + 1;
    		int k = nums.length - 1;
    		
    		while (j < k) {
	    		int twoSum = nums[j] + nums[k];
	    		
	    		if (pivot + twoSum < 0) {
	    			j++;
	    		}
	    		else if (pivot + twoSum > 0) {
	    			k--;
	    		}
	    		else {
	    			Pair p = new Pair(nums[i], nums[j]);
	    			if (pairs.contains(p)) {
	    				j++;
	    				k--;
	    				continue;
	    			}
	    		
	    			pairs.add(p);
	    			ArrayList<Integer> triplet = new ArrayList<>();
	    			triplet.add(nums[i]);
	    			triplet.add(nums[j]);
	    			triplet.add(nums[k]);
	    			threeSums.add(triplet);
	    			j++;
	    			k--;
	    		}
    		}
    	}
    	
    	return threeSums;
    }
    
    private static class Pair {
    	private int x;
    	private int y;
    	
    	public Pair(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    	
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
  
    }
    
    public static void main(String[] args) {
    	int[] nums = new int[]{0, 0, 0};
    	List<List<Integer>> sums = threeSum(nums);
    	
    	System.out.println("result:");
    	for (int i = 0; i < sums.size(); i++) {
    		ArrayList<Integer> list = (ArrayList<Integer>) sums.get(i);
    		for (int j = 0; j < list.size(); j++) {
    			System.out.print(list.get(j) + " ");
    		}
    		System.out.println("\n----");
    	}
    }
}
