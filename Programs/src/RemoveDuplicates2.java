
public class RemoveDuplicates2 {
	
	public static void main(String[] args) {
		String string = "AABCCCCBBA";
		if(string.length()<3)
			System.out.println(string);
		
		int count=1;
		for(int i=1;i<string.length(); i++) {
			char c = string.charAt(i);
			while(c==string.charAt(i-1)) {
				count++;
				if(i<string.length()-1) {
					i++;
					c = string.charAt(i);
				}else
					break;
			}
			if(count>=3) {
				string = string.substring(0, i-count)+string.substring(i);
				i=0;
				count=1;
			}
		}
		System.out.println(string);
	}

}
