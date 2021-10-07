package searchAlgorithms;

public class BinarySearch {
	
	static int count = 0;
	
	public static void main(String[] args) {
		
		int[] array = new int[] {1,2,3,4,5,6,7,8,9,10};
		System.out.println(binarySearch(array, 3));
		System.out.println("Counts : " + count);
	}
	
	public static boolean binarySearch(int[] array,int x) {
		count = 0;
		return binarySearch(array, x, 0, array.length-1);
	}
	
	public static boolean binarySearch(int[] array,int x, int left,int right) {
		
		if(left > right) {
			return false;
		}
		
		count++;
		
		int mid = (left + right)/2;
		
		if(array[mid] == x) {
			return true;
		}else if(x < array[mid]) {
			binarySearch(array, x,left,mid-1);
		}else {
			binarySearch(array, x,mid + 1,right);
		}
		
		return true;
	}
}



/*
Time Complexity: O(log n)
*/