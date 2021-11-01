package geeksforgeeks;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * 1 Nov 2021
 */

/**
 * https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/
 */

public class FindUnionAndIntersectionOfTwoUnsortedArray_Method1 {

	public static void main(String[] args) {
		int arr1[] = { 7, 1, 5, 2, 3, 6 };
        int arr2[] = { 3, 8, 6, 20, 7 };
        
        printUnion(arr1, arr2);
        printIntersection(arr1, arr2);
        PrintUnionAndIntersection(arr1, arr2);
	}
	
	static void printUnion(int arr1[],int arr2[]) {
		
		HashSet<Integer> hs1 = new HashSet<>();
		
		for(int i : arr1) {
			hs1.add(i);
		}
		
		for(int i : arr2) {
			hs1.add(i);
		}
		
		System.out.println(hs1);
	}
	
	static void printIntersection(int arr1[],int arr2[]) {
		
		HashSet<Integer> hs1 = new HashSet<>();
		
		for(int i : arr1) {
			hs1.add(i);
		}
		
		for(int i : arr2) {
			if(hs1.contains(i)) {
				System.out.print(i +" ");
			}
		}
		System.out.println();
		
	}
	
	static void PrintUnionAndIntersection(int arr1[],int arr2[]) {
		
		HashSet<Integer> union = new HashSet<>();
		ArrayList<Integer> interSection = new ArrayList<>();
		
		for(int i : arr1) {
			union.add(i);
		}
		
		for(int i : arr2) {
			if(union.contains(i)) {
				interSection.add(i);
			}else {
				union.add(i);
			}
		}
		
		System.out.println(union);
		System.out.println(interSection);
	}
}
