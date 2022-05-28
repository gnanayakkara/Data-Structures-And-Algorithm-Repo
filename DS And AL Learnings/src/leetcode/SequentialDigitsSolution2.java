package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 28 May 2022
 */

public class SequentialDigitsSolution2 {
	
	public static void main(String[] args) {
		
		System.out.println(sequentialDigitsSolution2(100, 300));
	}
	
	
	public static List<Integer> sequentialDigitsSolution2(int low, int high) {
		
		String digits = "123456789";
		List<Integer> ans = new ArrayList<Integer>();
		
		for(int i = 2; i < 10; i++) {
			
			for(int j = 0;j+i < 10; j++) {
				int value = Integer.valueOf(digits.substring(j, i+j));
				
				if(value >= low) {//12
					if(value <= high) {
						ans.add(value);
					}else {
						return ans;
					}
				}
			}
			
		}
		
		return ans;
	}

}


