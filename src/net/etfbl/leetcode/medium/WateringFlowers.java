package net.etfbl.leetcode.medium;

public class WateringFlowers {

	public int waterFlowers(int[] plants, int capacity1, int capacity2) {
		int refills = 0;
		int midpoint = (plants.length - 1) / 2;
		/* 0 1 2 3, midpoint = 1 */ 
		/* 0 1 2 3 4, midpoint = 2 */
		int left = 0, right = plants.length - 1;
		int currCapacity1 = capacity1;
		int currCapacity2 = capacity2;
		
		while (left < midpoint) {
			if (plants[left] <= currCapacity1) {
				currCapacity1 -= plants[left];
				left++;
			}
			else {
				currCapacity1 = capacity1;
				refills++;
			}
			if(plants[right] <= currCapacity2) {
				currCapacity2 -= plants[right];
				right--;
			}
			else {
				currCapacity2 = capacity2;
				refills++;
			}
		}
		
		if (plants.length % 2 != 0) {
			if (plants[left] <= currCapacity1) {
				currCapacity1 -= plants[left];
				left++;
			}
			else {
				currCapacity1 = capacity1;
				refills++;
			}
			
			/* the last plant remained - the one in the middle */
			if (!(currCapacity1 + currCapacity2 >= plants[left])) {
				refills++;
			}
		}
		
		
		return refills;
	}
	
	public static void main(String[] args) {
		WateringFlowers wf = new WateringFlowers();
		int[] plants = {2, 4, 5, 1, 2}; int cap1 = 5, cap2 = 7;
		System.out.println(wf.waterFlowers(plants, cap1, cap2));
	}
}
