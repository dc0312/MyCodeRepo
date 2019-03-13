package dataStructures.linkedlist;

class Link3{
	public int data;
	public Link3 next;
	public Link3 prev;
	
	public Link3(int dd) {
		data=dd;
	}
}
class DoubleLinkedList{
	public Link3 first; 
	public Link3 last;
	
	public DoubleLinkedList() {
		first = null;
		last = null;
	}
	
	public void insertFirst(int key) {
		Link3 newLink = new Link3(key);
		if(first == null) {
			last = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	
	public void insertLast(int key) {
		Link3 newLink = new Link3(key);
		if(first==null) {
			first = newLink;
		}else {
			last.next = newLink;
		}
		last=newLink;
	}
	
	public Link3 deleteFirst() {
		Link3 temp = first;
		if(first.next==null) {
			last=null;
		}
		first=first.next;
		return temp;
	}
	
	public void dislayList() {
		Link3 current = first;
		while(current != null) {
			System.out.println("Data :"+current.data);
			current = current.next;
		}
	}
}

public class DoubleLinkedListMain {
	
	public static void main(String[] args) {
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		
		doubleLinkedList.insertFirst(5);
		doubleLinkedList.insertFirst(3);
		doubleLinkedList.insertFirst(7);
		
		doubleLinkedList.dislayList();
		
		doubleLinkedList.insertLast(4);
		doubleLinkedList.insertLast(9);
		System.out.println("========================");
		doubleLinkedList.dislayList();
		
		
		doubleLinkedList.deleteFirst();
		
		System.out.println("************************");
		doubleLinkedList.dislayList();
	}

}
