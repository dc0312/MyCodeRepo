package dataStructures.recursion;

public class MergSortMain {
	
	public static void main(String[] args) {
		int maxSize1 =4;
		int [] arr1 = new int[maxSize1];
		arr1[0]= 4;
		arr1[1]=8;
		arr1[2]=12;
		arr1[3]=15;
		
		int maxSize2 = 5;
		int arr2 [] = new int[maxSize2];
		arr2[0]=1;
		arr2[1]=3;
		arr2[2]=9;
		arr2[3]=13;
		arr2[4]=19;
		
		int [] arr3 = new int[maxSize1+maxSize2];
		
		mergeSort(arr1,maxSize1,arr2,maxSize2,arr3);
		
		for (int i : arr3) {
			System.out.println(i);
		}
	}

	private static void mergeSort(int[] arr1, int maxSize1, int[] arr2, int maxSize2, int[] arr3) {
		int arr1Index = 0,arr2Index = 0,arr3Index = 0;
		
		while(arr1Index<maxSize1 && arr2Index<maxSize2) {
			if(arr1[arr1Index]<arr2[arr2Index]) {
				arr3[arr3Index++] = arr1[arr1Index++];
			}else {
				arr3[arr3Index++] = arr2[arr2Index++];
			}
		}
		
		while(arr1Index<maxSize1) {
			arr3[arr3Index++] = arr1[arr1Index++];
		}
		
		while(arr2Index<maxSize2) {
			arr3[arr3Index++] = arr2[arr2Index++];
		}
	}

}
