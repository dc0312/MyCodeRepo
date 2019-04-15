package dataStructures.linkedlist;

class FindLoopLinkedList{
	Link first ;
	
	public FindLoopLinkedList() {
		first = null;
	}
	
	public void displayList() {
		Link current = first;
		while(current!=null) {
			System.out.print(current.data+" ");
			current= current.next;
		}
	}
	
	public Link findLoopNode() {
		Link slowPtr = first;
		Link fastPtr = first;
		
		while(slowPtr != null && fastPtr != null && fastPtr.next != null) {
			slowPtr= slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(slowPtr.data==fastPtr.data) {
				System.out.println(slowPtr.data+ " ");
				return slowPtr;
			}
		}
		return null;
	}
	
	public Link originOfLoop() {
		Link loopPtr = findLoopNode();
		Link current = first;
		
		while(loopPtr.data != current.data) {
			loopPtr = loopPtr.next;
			current = current.next;
		}
		
		System.out.println(current.data + " ");
		return current;
	}
	
	public void removeLoop() {
		Link loopPtr = findLoopNode();
		Link current = first;
		Link previous = findLoopNode();
		
		while(loopPtr.data != current.data) {
			previous = loopPtr;
			loopPtr = loopPtr.next;
			current = current.next;
		}
		
		previous.next = null;
		
	}
	
	public void reverssLL() {
		Link current = first;
		Link previous;
		while(null != current.next) {
			previous = current;
			current=current.next;
			if(previous==first) {
				current.next = null;
			}else {
				current.next = previous;
			}
			
		}
		first = current;
	}
}

public class FindLoopLinkedListMain {
	
	public static void main(String[] args) {
		FindLoopLinkedList  findLoopLinkedList = new FindLoopLinkedList();
		findLoopLinkedList.first = new Link(1);
		findLoopLinkedList.first.next = new Link(2);
		findLoopLinkedList.first.next.next = new Link(3);
		findLoopLinkedList.first.next.next.next = new Link(4);
		findLoopLinkedList.first.next.next.next.next= new Link(5);
		findLoopLinkedList.first.next.next.next.next.next = new Link(6);
		findLoopLinkedList.first.next.next.next.next.next.next = new Link(7);
		findLoopLinkedList.first.next.next.next.next.next.next.next = new Link(8);
		findLoopLinkedList.first.next.next.next.next.next.next.next.next = new Link(9);
		findLoopLinkedList.first.next.next.next.next.next.next.next.next.next = new Link(10);
		
		findLoopLinkedList.first.next.next.next.next.next.next.next.next.next.next = findLoopLinkedList.first.next.next;
		
		//findLoopLinkedList.displayList();
		findLoopLinkedList.findLoopNode();
		findLoopLinkedList.originOfLoop();
		findLoopLinkedList.removeLoop();
		findLoopLinkedList.displayList();
		findLoopLinkedList.reverssLL();
		findLoopLinkedList.displayList();
	}

}
