import java.util.Stack;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		String characters = "ABCCCCBBA";
        Stack<Character> stackOfChars = new Stack<Character>();
        fillStackInReverseOrder(stackOfChars,characters);
        Stack <Character> tempStackOfChars = new Stack<>();
        
        int numberOfRepetitions=1;//we always have 1 repetition for 1 char
        while(!stackOfChars.isEmpty()){
            tempStackOfChars.push(stackOfChars.pop());
            if(!tempStackOfChars.isEmpty() && 
               !stackOfChars.isEmpty() &&
               stackOfChars.peek()==tempStackOfChars.peek()){
                numberOfRepetitions++;
            }else{
                if(numberOfRepetitions>=3){
                    popTopChars(numberOfRepetitions,tempStackOfChars);
                    copyElements(tempStackOfChars,stackOfChars,2);
                }
                numberOfRepetitions=1;//we always have 1 repetition for 1 char
            }
        }
        
      //printing
        StringBuilder outputString=new StringBuilder();
        while(tempStackOfChars.size()>0){
            outputString=outputString.append(tempStackOfChars.pop());
        }
        System.out.println(outputString.reverse().toString());
	}

	private static void copyElements(Stack<Character> fromStack, Stack<Character> toStack, int count) {
		for(int i=0;i<count && fromStack.size()>0;i++){
            toStack.push(fromStack.pop());
        }
	}

	private static void popTopChars(int numberOfRepetitions, Stack<Character> tempStackOfChars) {
		for(int i=0;i<numberOfRepetitions && tempStackOfChars.size()>0;i++){
            tempStackOfChars.pop();
        }
	}

	private static void fillStackInReverseOrder(Stack<Character> stackOfChars, String characters) {
		for(int i =characters.length()-1;i>=0;i--){
			stackOfChars.push(characters.charAt(i));
        }
	}

}
