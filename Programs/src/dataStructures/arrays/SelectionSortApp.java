package dataStructures.arrays;

class ArraySel{
	private int [] arr;
	private int nElems;
	
	public ArraySel(int maxSize) {
		arr = new int[maxSize];
		nElems=0;
	}
	
	public void insert(int i) {
		arr[nElems] = i;
		nElems++;
	}
	
	public void display() {
		for(int i =0;i<nElems;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public void selectionSort() {
		int in, out,min;
		
		for(out=0;out<nElems-1;out++) {
			min=out;
			for(in=out+1;in<nElems;in++) {
				if(arr[in]<arr[min]) {
					min = in;
				}
			}
			int temp = arr[out];
			arr[out] = arr[min];
			arr[min] =  temp;
		}
	}
}
public class SelectionSortApp {
	public static void main(String[] args) {
		int size = 100;
		ArraySel arr = new ArraySel(size);
		
		arr.insert(9);
		arr.insert(15);
		arr.insert(12);
		arr.insert(1);
		arr.insert(17);
		
		arr.display();
		
		arr.selectionSort();
		
		arr.display();
	}
}
