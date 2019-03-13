package dataStructures.linkedlist;

class Stack{
	LinkList linkList;
	
	Stack(int s){
		linkList = new LinkList();
	}
	
	public void push(int i) {
		linkList.insertFirst(i);
	}
	
	public int pop() {
		return linkList.deleteFirst().data;
	}
	
	public void display() {
		linkList.displayList();
	}
}

public class StackUsingLinkedList {
	
	public static void main(String[] args) {
		Stack stack = new Stack(10);
		stack.push(10);
		stack.push(5);
		stack.push(3);
		stack.push(2);
		
		stack.display();
		
		stack.pop();
		
		System.out.println("==============");
		
		stack.display();
	}

}
