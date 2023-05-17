package Solving;

import java.util.ArrayList;
import java.util.List;

public class BinaryArraySorting {
	
	/*
	 * Find how many movement required to sort binary array
	 * sort can done in two ways
	 * 		first way : all 1s in left side and all 0s in right
	 * 	    second way : all 0s in left side and all 1s in right
	 * find the minimum moves required to sort array.
	 */
	
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(0);
		arr.add(1);
		arr.add(1);
		arr.add(0);
		
		System.out.println(minMoves(arr));
	}
	
	public static int minMoves(List<Integer> arr) {
		
		int zeroCount = 0;
		int rightCount = 0;
		int leftCount = 0;
		
		if(arr == null || arr.size() == 0) {
			return 0;
		}
		
		for(int i = arr.size()-1; i >= 0; i--) {
			if(arr.get(i) == 0) {
				zeroCount++;
			}else {
				rightCount += zeroCount;
			}
		}
		
		System.out.println("Right Count : "+ rightCount );
		System.out.println("Zero Count : "+ zeroCount );
		
		zeroCount = 0;
		
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == 0) {
				zeroCount++;
			} else {
				leftCount += zeroCount;
			}
		}
		System.out.println("Left Count : " + leftCount);
		System.out.println("Zero Count : "+ zeroCount);
		
		return Math.min(rightCount, leftCount);
	}
}
