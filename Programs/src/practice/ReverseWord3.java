package practice;

class Stack {
	private char [] stackArr;
	private int top;
	
	Stack(int maxSize){
		stackArr = new char[maxSize];
		top = -1;
	}
	
	public void push(char i) {
		stackArr[++top] = i;
	}
	
	public char pop() {
		return stackArr[top--];
	}
	
	public boolean isEmpty() {
		return top ==-1;
	}
}
public class ReverseWord3 {
	
	public static String reverse(String word) {
		Stack stackArr = new Stack(word.length());
		for (char c : word.toCharArray()) {
			stackArr.push(c);
		}
		
		StringBuilder builder = new StringBuilder();
		
		while(!stackArr.isEmpty()) {
			builder.append(stackArr.pop());
		}
		
		return new String(builder);
	}
	public static void main(String[] args) {
		String word = "Deepak";
		
		System.out.println("Reverse :"+reverse(word));
	}
}
