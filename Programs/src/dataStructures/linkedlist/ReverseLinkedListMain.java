package dataStructures.linkedlist;

class ReverseLL{
	Link first;
	
	public ReverseLL() {
		first = null;
	}
	
	public void displayList() {
		Link current = first;
		while(current!=null) {
			System.out.print(current.data+" ");
			current= current.next;
		}
	}
	
	public void reverse() {
		Link previous = null;
		Link current = first;
		Link next = null;
		
		while(current!=null) {
			next = current.next;
			current.next=previous;
			previous=current;
			current = next;
		}
		first = previous;
	}
	
	
}
public class ReverseLinkedListMain {
	
	public static void main(String[] args) {
		ReverseLL reverseLL = new ReverseLL();
		reverseLL.first = new Link(10);
		reverseLL.first.next = new Link(20);
		reverseLL.first.next.next = new Link(30);
		reverseLL.first.next.next.next = new Link(40);
		
		reverseLL.reverse();
		
		reverseLL.displayList();
	}

}
