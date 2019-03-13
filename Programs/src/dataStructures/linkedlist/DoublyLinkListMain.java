package dataStructures.linkedlist;

class Link2{
	public int data;
	public Link2 next;
	public Link2 prev;
	
	public Link2(int dd) {
		data=dd;
	}
}
class DoublyLinkList{
	public Link2 first;
	public Link2 last;
	
	public DoublyLinkList() {
		first = null;
		last = null;
	}
	
	public void insertFirst(int i) {
		Link2 newLink = new Link2(i);
		if(first == null) {
			last = newLink;
		}else {
			first.prev = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	
	public void insertLast(int i) {
		Link2 newLink = new Link2(i);
		if(first == null) {
			first = newLink;
		}else {
			newLink.prev = last;
			last.next = newLink;
		}
		last = newLink;
	}
	
	public void insertAfter(int dd, int key) {
		Link2 newLink = new Link2(key);
		Link2 current = first;
		while(current.data != dd) {
			current = current.next;
		}
		
		if(current.next==null) {
			last = newLink;
		}else {
			newLink.next = current.next;
			current.next.prev = newLink;
		}
		newLink.prev = current;
		current.next = newLink;
	}
	
	public void deleteFirst() {
		Link2 temp = first;
		if(first.next == null) {
			last = null;
		}else {
			first.next.prev = null;
		}
		first = first.next;
	}
	
	public void deleteLast() {
		Link2 temp = last;
		if(first.next == null) {
			first = null;
		}else {
			last.prev.next = null;
		}
		last = last.prev;
	}
	
	public void displayList() {
		Link2 current = first;
		while(current != null) {
			System.out.println("Data :"+current.data);
			current = current.next;
		}
	}
}
public class DoublyLinkListMain {
	public static void main(String[] args) {
		DoublyLinkList doubleLinkedList = new DoublyLinkList();
		doubleLinkedList.insertFirst(10);
		doubleLinkedList.insertFirst(12);
		doubleLinkedList.insertFirst(16);
		
		doubleLinkedList.displayList();
		
		doubleLinkedList.insertLast(9);
		
		System.out.println("=================");
		
		doubleLinkedList.displayList();
		
		System.out.println("======================");
		
		doubleLinkedList.insertAfter(12,13);
		
		doubleLinkedList.displayList();
		
		doubleLinkedList.deleteFirst();
		
		System.out.println("=================");
		
		doubleLinkedList.displayList();
		
		
		doubleLinkedList.deleteLast();
		
		System.out.println("=================");
		
		doubleLinkedList.displayList();
		
	}
}
