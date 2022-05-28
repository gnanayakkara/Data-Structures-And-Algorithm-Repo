package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 27 May 2022
 * https://leetcode.com/problems/sequential-digits/
 */

public class SequentialDigits {

	private static List<Integer> list = null;

	public static void main(String[] args) {
		
		list = new ArrayList<Integer>();
		System.out.println(sequentialDigits(100, 300));
	}

	public static List<Integer> sequentialDigits(int low, int high) {

		for (int i = 1; i <= 8; i++) {
			helper(i, low, high);
		}
		Collections.sort(list);
		return list;
	}

	public static void helper(int current, int low, int high) {

		if (current > high) {
			return;
		}

		if (current >= low) {
			list.add(current);
		}

		if (current % 10 == 9) {
			return;
		}

		int next = (current * 10) + (current % 10) + 1;

		helper(next, low, high);
	}

	

}
