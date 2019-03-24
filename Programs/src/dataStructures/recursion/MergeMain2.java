package dataStructures.recursion;

class DArray{
	private int [] arr;
	private int nElems;
	
	DArray(int max){
		arr = new int[max];
		nElems =0;
	}
	
	public void insert(int i) {
		arr[nElems++] = i;
	}
	
	public void display() {
		for(int j=0;j<nElems;j++) {
			System.out.print(arr[j]+" ");
		}
		System.out.println();
	}
	
	public void mergeSort() {
		int [] mergedArr = new int[nElems];
		recMergeSort(mergedArr,0,nElems-1);
	}

	private void recMergeSort(int[] mergedArr, int lowerBound, int upperBound) {
		if(lowerBound==upperBound) {
			return;
		}else {
			int mid = (lowerBound + upperBound)/2;
			System.out.println("Pehla rec");
			recMergeSort(mergedArr, lowerBound, mid);
			System.out.println("doosara rec");
			recMergeSort(mergedArr, mid+1, upperBound);
			System.out.println("merge call hua");
			merge(mergedArr,lowerBound,mid+1,upperBound);
		}
	}

	private void merge(int[] mergedArr, int lowPtr, int highPtr, int upperBound) {
		int j =0;
		int lowerBound = lowPtr;
		int mid = highPtr -1;
		int n = upperBound - lowerBound+1;
		
		while(lowPtr <= mid && highPtr <=upperBound) {
			if(arr[lowPtr] < arr[highPtr]) {
				mergedArr[j++] = arr[lowPtr++];
			}else {
				mergedArr[j++] = arr[highPtr++];
			}
		}
		
		while(lowPtr <= mid) {
			mergedArr[j++] = arr[lowPtr++];
		}
		while(highPtr<=upperBound) {
			mergedArr[j++]=arr[highPtr++];
		}
		
		for(j =0; j<n ; j++) {
			arr[lowerBound+j] = mergedArr[j];
		}
	}
}

public class MergeMain2 {
	public static void main(String[] args) {
		int max = 4;
		DArray arr = new DArray(max);
		arr.insert(10);
		arr.insert(9);
		arr.insert(14);
		arr.insert(18);
		
		arr.display();
		
		arr.mergeSort();
		
		arr.display();
 	}
}
