package sortings;

/**
 * This way we are using only for sorted arrays
 */
public class TwoWayMergeSort {
	
	public static void main(String[] args) {
		
		int[] arrayA = new int[] {2, 8, 15, 18};
		int[] arrayB = new int[] {5, 9, 12, 17};
		
		int[] mergeArray = mergeSort(arrayA, arrayB);
		
		for(int i : mergeArray) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] mergeSort(int[] arrayA,int[] arrayB) {
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		int[] tempArray = new int[arrayA.length+arrayB.length];
		
		while(i < arrayA.length && j < arrayB.length ) {
			if(arrayA[i] < arrayB[j]) {
				tempArray[k++] = arrayA[i++];
			}else{
				tempArray[k++] = arrayB[j++];
			}
		}
		
		//If arrays length is not same, rest need to merge to new array
		for(; i < arrayA.length;i++ ) {
			tempArray[k++] = arrayA[i];
		}
		
		for(;j < arrayB.length; j++) {
			tempArray[k++] = arrayB[j];
		}
		
		return tempArray;
		
	}

}
