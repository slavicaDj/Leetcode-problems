package net.etfbl.leetcode.medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class ThreeSumBF {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listOfThreeSums = new ArrayList<List<Integer>>();
        HashSet<Pair> pairs = new HashSet<>();
        
        /* nlogn */
        Arrays.sort(nums);
        System.out.println("sorted array:");
        for (int i : nums)
        	System.out.print(i + " ");
        System.out.println();
        
        /* n2 */
        for (int i = 0; i < nums.length - 2; i++) {
        	for (int j = i + 1; j < nums.length - 1; j++) {
	        	Pair p = new Pair(nums[i], nums[j]);
	        	if (pairs.contains(p))
	        		continue;
	        	pairs.add(p);
        		
	            int compl = nums[i] + nums[j];

	            /* logn */
	            int index_compl = binarySearch(nums, j + 1, nums.length - 1, -compl);

	            if (index_compl != -1) {
	                System.out.println("index: " + index_compl);
	                List<Integer> threeSum = new ArrayList<>();
	                threeSum.add(nums[i]);
	                threeSum.add(nums[j]);
	                threeSum.add(nums[index_compl]);
	                listOfThreeSums.add(threeSum);
	            }
	        }
        }
        
        return listOfThreeSums;
    }
    
    public static int binarySearch(int[] array, int low, int high, int value) {
        if (low > high)
        	return -1;
//        System.out.println("binary search for key: " + value);
//        for (int i = low; i <= high; i++) {
//        	System.out.print(array[i] + " ");
//        }
//        System.out.println();
        int mid = (low + high) / 2;
        if (value < array[mid])
        	return binarySearch(array, low, mid - 1, value);
        else if (value > array[mid])
        	return binarySearch(array, mid + 1, high, value);
        else
        	return mid;
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
    	int[] nums = new int[]{-1,0,1,2,-1,-4};
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