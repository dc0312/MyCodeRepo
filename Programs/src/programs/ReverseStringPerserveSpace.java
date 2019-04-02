package programs;

public class ReverseStringPerserveSpace {
	public static void main(String[] args) {
		String s = "Deepak is a good boy.";
		
		char [] c = s.toCharArray();
		int left =0;
		int right = s.length()-1;
		
		while(left<right) {
			if(c[left]==' ' ) {
				left++;
				continue;
			}else if (c[right] == ' '  ) {
				right--;
				continue;
			}else {
				char temp = c[left];
				c[left] =c[right];
				c[right] = temp;
				left++;
				right--;
			}
		}
		
		System.out.println(new String(c));
		
	}
}
