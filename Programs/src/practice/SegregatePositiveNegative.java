package practice;

public class SegregatePositiveNegative {
	
	private static void logic(int[] arr) {
		int left =0;
		int right = arr.length-1;
		
		while(left<right) {
			while(arr[left]<0) {
				left++;
			}
			while(arr[right]>0) {
				right--;
			}
			if(left<right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] =temp;
			}
		}
		
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		int [] arr = {-2,1,-5,-3,6,0,-7,-9};
		
		logic(arr);
	}

}
