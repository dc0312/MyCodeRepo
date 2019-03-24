package practice;

public class ReverseWord1 {
	
	public static String reverse(String word) {
		char [] charArr = word.toCharArray();
		int left =0;
		int right = charArr.length-1;
		
		while(left<right) {
			char temp = charArr[left];
			charArr[left] = charArr[right];
			charArr[right] =  temp;
			left++;
			right--;
		}
		
		return new String(charArr);
	}
	public static void main(String[] args) {
		String word = "Deepa";
		
		System.out.println("Reverse Word:"+ reverse(word));
		
		Integer i1 = 1000;
		Integer i2 =1000;
		if(i1==i2) System.out.println("i1==i2");
		if(i1.equals(i2)) System.out.println("i1.equals(i2)");
		if(i1!=i2) System.out.println("i1!=i2");
		
	}
}
