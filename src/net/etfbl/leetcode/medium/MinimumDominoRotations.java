package net.etfbl.leetcode.medium;
import java.util.HashMap;

public class MinimumDominoRotations {
    public static int minDominoRotations(int[] A, int[] B) {
              if (A == null || B == null || A.length != B.length)
        	return -1;

        int rotA = dominoRotations(A, B);
        int rotB = dominoRotations(B, A);
        if (rotA == -1)
        	return rotB;
        if (rotB == -1)
        	return rotA;
        return Math.min(dominoRotations(A, B), dominoRotations(B, A));
    }
	
	private static int dominoRotations(int[] a, int[] b) {
		int rot = 0;
		HashMap<Integer, Integer> mapA = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			if (mapA.containsKey(a[i])) {
				mapA.put(a[i], mapA.get(a[i]) + 1);
			}
			else {
				mapA.put(a[i], 1);
			}
		}
		
		int maxValue = -1;
		int maxKey = -1;
		for (int i = 1; i <= 6; i++) {
			Integer value = mapA.get(i);
			if (value == null)
				continue;
			if(mapA.get(i) > maxValue) {
				maxKey = i;
				maxValue = mapA.get(i);
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] != maxKey) {
				 if (b[i] != maxKey)
					return -1;
				 rot++;
			}
		}
	
        return rot;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{5, 3, 3};
		int[] b = new int[]{3, 2, 2};
		
		int ans = minDominoRotations(a, b);
		System.out.println(ans);
	}
		
}