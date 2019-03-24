package practice;

public class ReverseWord2 {
	
	public static String reverse(String word) {
		char [] charArr = word.toCharArray();
		StringBuilder builder = new StringBuilder();
		
		for(int i=charArr.length-1; i >=0;i-- ) {
			builder.append(charArr[i]);
		}
		
		return new String(builder);
	}
	public static void main(String[] args) {
		String word = "Deep";
		
		System.out.println("Reverse Word: "+reverse(word));
	}
}
