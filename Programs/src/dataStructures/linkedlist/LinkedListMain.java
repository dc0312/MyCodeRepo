package dataStructures.linkedlist;

class Link {
	public int data;
	public Link next;

	public Link(int data) {
		this.data = data;
	}
}
class LinkList{
	public Link first;
	
	public LinkList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int i) {
		Link newLink = new Link(i);
		newLink.next = first;
		first = newLink;
	}
	
	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		Link current = first;
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
			
		}
	}
	
	public Link find(int key) {
		Link current = first;
		
		while(current.data != key) {
			if(current.next == null) {
				return null;
			}else {
				current = current.next;
			}
		}
		return current;
	}
	
	public Link delete(int key) {
		Link current = first;
		Link previous = first;
		
		while(current.data != key) {
			if(current.next == null) {
				return null;
			}else {
				previous = current;
				current = current.next;
			}
		}
		
		if(current == first) {
			first = first.next;
		}else {
			previous.next = current.next;
		}
		return current;
	}
}
public class LinkedListMain {
	
	public static void main(String[] args) {
		LinkList linkList = new LinkList();
		linkList.insertFirst(10);
		linkList.insertFirst(12);
		linkList.insertFirst(17);
		linkList.insertFirst(19);
		
		linkList.displayList();
		
		/*while(!linkList.isEmpty()) {
			System.out.println(linkList.deleteFirst().data);
		}*/
		
		System.out.println("Data :"+linkList.find(1) );
		
		System.out.println("Data Deleted :"+linkList.delete(19).data);
		
	}

}
