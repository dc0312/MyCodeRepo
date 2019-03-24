package practice;

public class SegregateEvenOdd {
	
	private static void logic(int [] arr) {
		int left =0;
		int right = arr.length-1;
		
		while(left<right) {
			while(arr[left]%2==0 && left<right) {
				left++;
			}
			while(arr[right]%2==1 && left<right) {
				right--;
			}
			
			if(arr[left]%2==1 && arr[right]%2==0 && left<right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] =temp;
				left++;
				right--;
			}
			
		}
		
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		int [] arr = {4,3,2,1,6};
		
		logic(arr);
	}
}
