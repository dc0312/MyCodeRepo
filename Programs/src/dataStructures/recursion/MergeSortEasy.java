package dataStructures.recursion;

import java.util.Arrays;

public class MergeSortEasy {
	private static int[] numbers = { 2,1,3};
	private static int[] helper = new int[numbers.length];

	public static void main(String[] args) {
		System.out.println(Arrays.toString(numbers));
		mergesort(0, numbers.length - 1);
		System.out.println(Arrays.toString(numbers));
	}

	private static void mergesort(int low, int high) {

		if (low < high) {
			//get the index of the middle element.
			int middle = (low + high) / 2;
			System.out.println("Middle "+ middle + " element : "+numbers[middle]);
			//sort the left side of the array.
			System.out.println("left mergesort  "+low +" "+middle);
			mergesort(low, middle);
			//sort the right side of the array
			System.out.println("right mergesort  "+(middle+1) +" "+high);
			mergesort(middle + 1, high);
			//combine them both
			System.out.println("merge "+ low +" "+middle +" "+high);
			merge(low, middle, high);
		}
	}

	private static void merge(int low, int middle, int high) {

		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		while (i <= middle && j <= high) {
			if(helper[i]<helper[j]) {
				numbers[k++] = helper[i++];
			}else {
				numbers[k++] = helper[j++];
			}
		}

		while (i <= middle) {
			numbers[k++] = helper[i++];
		}
		//this condition is not required as right array will either be equal to left array or will be short. 
		while(j<=middle) {
			numbers[k++] = helper[j++];
		}
	}
}
