package dataStructures.recursion;

public class BinarySearchRecursionMain {
	
	public static int binarySearch(int[] arr,int searchKey,int lowerBound, int upperBound) {
		int curIn;
		
		curIn = (lowerBound + upperBound)/2;
		
		if(arr[curIn] == searchKey) {
			return arr[curIn];
		}else if(lowerBound > upperBound) {
			return -1;
		}else {
			if(arr[curIn] < searchKey) {
				return binarySearch(arr, searchKey, curIn+1, upperBound);
			}else {
				return binarySearch(arr, searchKey, lowerBound, curIn-1);
			}
		}
	}
	public static void main(String[] args) {
		int maxSize =10;
		int [] arr = new int[maxSize];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i;
		}
		
		System.out.println(binarySearch(arr, 7, 0, arr.length));
	}
}
