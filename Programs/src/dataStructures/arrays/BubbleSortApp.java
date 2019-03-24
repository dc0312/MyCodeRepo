package dataStructures.arrays;

class ArrayBub {
	private int[] arr;
	private int nElems;

	public ArrayBub(int max) {
		arr = new int[max];
		nElems = 0;
	}

	public void insert(int i) {
		arr[nElems] = i;
		nElems++;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public void bubbleSort() {
		int in, out;
		
		for(out=nElems-1; out>1;out--) {
			for(in=0;in<out;in++) {
				if(arr[in]>arr[out]) {
					int temp = arr[out];
					arr[out] = arr[in];
					arr[in]=temp;
				}
			}
		}
	}
}

public class BubbleSortApp {
	public static void main(String[] args) {
		int size = 100;
		ArrayBub arr = new ArrayBub(size);
		
		arr.insert(10);
		arr.insert(12);
		arr.insert(14);
		arr.insert(13);
		arr.insert(15);
		
		arr.display();
		
		arr.bubbleSort();
		
		arr.display();
	}
}
