package dataStructures.linkedlist;

class LinkQueue{
	DoubleLinkedList doubleLinkedList;
	
	public LinkQueue() {
		doubleLinkedList = new DoubleLinkedList();
	}
	
	public void insert(int i) {
		doubleLinkedList.insertLast(i);
	}
	
	public int remove() {
		return doubleLinkedList.deleteFirst().data;
	}
	
	public void diplayQueue() {
		doubleLinkedList.dislayList();
	}
}

public class QueueUsingDoubleLinkList {
	
	public static void main(String[] args) {
		LinkQueue linkQueue = new LinkQueue();
		linkQueue.insert(10);
		linkQueue.insert(12);
		linkQueue.insert(14);
		
		linkQueue.diplayQueue();
		
		linkQueue.remove();
		
		System.out.println("======================");
		
		linkQueue.diplayQueue();
	}
	
}
